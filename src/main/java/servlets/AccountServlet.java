package servlets;

import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/user/account", name = "AccountServlet")
public class AccountServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        req.setAttribute("userId", user.getId());
        req.setAttribute("userName", user.getUserName());
        req.setAttribute("userLogin", user.getLogin());
        req.setAttribute("userPassword", user.getPassword());
        getServletContext().getRequestDispatcher("/pages/account.jsp").forward(req, resp);
    }
}
