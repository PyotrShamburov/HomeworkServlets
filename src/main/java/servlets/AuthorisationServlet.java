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

@WebServlet(urlPatterns = "/enter", name = "AuthorisationServlet")
public class AuthorisationServlet extends HttpServlet {
    private InMemoryStorage inMemoryStorage = new InMemoryStorage();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/pages/authorisation.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        User user = inMemoryStorage.getUserByLogin(login);
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
    }
}

