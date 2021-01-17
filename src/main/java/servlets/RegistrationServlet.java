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

@WebServlet(urlPatterns = "/reg", name = "RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
    private InMemoryStorage inMemoryStorage = new InMemoryStorage();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/pages/registration.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("name");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        if (inMemoryStorage.getUserByLogin(login) == null) {
            User user = new User(userName, login, password);
            inMemoryStorage.saveUser(user);
            resp.sendRedirect("/enter");
        } else {
            req.setAttribute("result", "User with this login already exists!");
            getServletContext().getRequestDispatcher("/pages/registration.jsp").forward(req, resp);
        }
    }
}


