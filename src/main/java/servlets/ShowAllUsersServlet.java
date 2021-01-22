package servlets;

import model.User;
import storage.InMemoryUserStorage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(urlPatterns = "/user/all",name = "AllUsersServlet")
public class ShowAllUsersServlet extends HttpServlet {
    private InMemoryUserStorage inMemoryUserStorage = new InMemoryUserStorage();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> all = inMemoryUserStorage.getUsers();
        req.setAttribute("users", all);
        getServletContext().getRequestDispatcher("/pages/users.jsp").forward(req, resp);
    }
}
