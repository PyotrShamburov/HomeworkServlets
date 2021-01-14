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

@WebServlet(urlPatterns = "/enter")
public class AuthorisationServlet extends HttpServlet {
    private InMemoryStorage inMemoryStorage = new InMemoryStorage();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/pages/authorisation.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Pattern pattern = Pattern.compile("\\w{2,15}");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        User user = inMemoryStorage.getUserByLogin(login);
        User userActive = (User) req.getSession().getAttribute("user");
        if (userActive == null) {
            if (!login.isEmpty() && !password.isEmpty()) {
                if (pattern.matcher(login).matches() && pattern.matcher(password).matches()) {
                    if (user != null) {
                        if (user.getPassword().equals(password)) {
                            req.getSession().setAttribute("user", user);
                            resp.sendRedirect("/");
                        } else {
                            req.setAttribute("result", "Your password or login is wrong!");
                            getServletContext().getRequestDispatcher("/pages/authorisation.jsp").forward(req, resp);
                        }
                    } else {
                        req.setAttribute("result", "User with this login doesn't exist!");
                        getServletContext().getRequestDispatcher("/pages/authorisation.jsp").forward(req, resp);
                    }
                } else {
                    req.setAttribute("result", "Wrong symbols for login or password!");
                    getServletContext().getRequestDispatcher("/pages/authorisation.jsp").forward(req, resp);
                }
            } else {
                req.setAttribute("result", "Login or password field can't be empty!");
                getServletContext().getRequestDispatcher("/pages/authorisation.jsp").forward(req, resp);
            }
        } else {
            req.setAttribute("result", "You already authorized your profile!");
            getServletContext().getRequestDispatcher("/pages/authorisation.jsp").forward(req, resp);
        }
    }
}
