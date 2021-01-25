package servlets;

import model.Author;
import model.Book;
import storage.InMemoryAuthorStorage;
import storage.InMemoryBookStorage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/author/view",name = "AuthorViewServlet")
public class AuthorViewServlet extends HttpServlet {
    private static InMemoryAuthorStorage inMemoryAuthorStorage = InMemoryAuthorStorage.getInstance();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Author author = inMemoryAuthorStorage.getById(Integer.parseInt(req.getParameter("id")));
        req.setAttribute("author",author);
        getServletContext().getRequestDispatcher("/pages/authorView.jsp").forward(req,resp);
    }
}
