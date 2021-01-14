package servlets;

import model.User;
import storage.InMemoryStorage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Pattern;

@WebServlet(urlPatterns = "/reg")
public class RegistrationServlet extends HttpServlet {
    private InMemoryStorage inMemoryStorage = new InMemoryStorage();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/pages/registration.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Pattern pattern = Pattern.compile("\\w{2,15}");
        String userName = req.getParameter("name");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        User userActive = (User) req.getSession().getAttribute("user");
        if (userActive == null) {
            if (userName.matches("(\\p{Upper}?)(\\p{Lower}{2,15})") && pattern.matcher(login).matches() &&
                    pattern.matcher(password).matches()) {
                if (inMemoryStorage.getUserByLogin(login) == null) {
                    User user = new User(userName, login, password);
                    inMemoryStorage.saveUser(user);
                    resp.sendRedirect("/enter");
                } else {
                    req.setAttribute("result", "User with this login already exists!");
                    getServletContext().getRequestDispatcher("/pages/registration.jsp").forward(req, resp);
                }
            } else {
                req.setAttribute("result", "Wrong symbols for login or password or user's name!\n" +
                        "Their fields can't be empty and must have length from 3 to 15 symbols!");
                getServletContext().getRequestDispatcher("/pages/registration.jsp").forward(req, resp);
            }
        } else {
            req.setAttribute("result", "For registration new user, you need make logout!");
            getServletContext().getRequestDispatcher("/pages/registration.jsp").forward(req, resp);
        }
    }
}
