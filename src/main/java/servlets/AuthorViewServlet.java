package servlets;

import model.Author;
import model.Book;
import storage.InMemoryBookStorage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/author/view")
public class AuthorViewServlet extends HttpServlet {
    private InMemoryBookStorage inMemoryBookStorage = InMemoryBookStorage.getInstance();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Book byId = inMemoryBookStorage.getById(Integer.parseInt(req.getParameter("id")));
        Author author = byId.getAuthor();
        req.setAttribute("author",author);
        getServletContext().getRequestDispatcher("/pages/authorView.jsp").forward(req,resp);
    }
}
