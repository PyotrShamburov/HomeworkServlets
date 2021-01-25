package servlets;

import model.Role;
import model.User;
import storage.InMemoryUserStorage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/reg", name = "RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
    private InMemoryUserStorage inMemoryUserStorage = new InMemoryUserStorage();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/pages/registration.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("name");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        if (inMemoryUserStorage.getUserByLogin(login) == null) {
            User user = new User(userName, login, password,Role.USER);
            inMemoryUserStorage.saveUser(user);
            resp.sendRedirect("/enter");
        } else {
            req.setAttribute("result", "User with this login already exists!");
            getServletContext().getRequestDispatcher("/pages/registration.jsp").forward(req, resp);
        }
    }
}


