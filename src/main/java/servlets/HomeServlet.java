package servlets;

import model.User;
import storage.InMemoryBookStorage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/")
public class HomeServlet extends HttpServlet {
    private InMemoryBookStorage inMemoryBookStorage = InMemoryBookStorage.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("books",inMemoryBookStorage.getAll());
        boolean isUser = (boolean) req.getSession().getAttribute("isUser");
        if(isUser) {
            User user = (User) req.getSession().getAttribute("user");
            req.setAttribute("name", user.getUserName());
        }
        getServletContext().getRequestDispatcher("/pages/home.jsp").forward(req, resp);
    }
}
