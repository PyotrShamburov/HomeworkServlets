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

@WebServlet(urlPatterns = "/enter", name = "AuthorisationServlet")
public class AuthorisationServlet extends HttpServlet {
    private InMemoryUserStorage inMemoryUserStorage = new InMemoryUserStorage();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/pages/authorisation.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        User user = inMemoryUserStorage.getUserByLogin(login);
        if (user != null) {
            if (user.getPassword().equals(password)) {
                req.getSession().setAttribute("user", user);
                req.getSession().setAttribute("isUser",true);
                req.getSession().setAttribute("isGuest",false);
                if (user.getRole().equals(Role.ADMIN)){
                    req.getSession().setAttribute("isUser",false);
                    req.getSession().setAttribute("isAdmin",true);
                }
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

