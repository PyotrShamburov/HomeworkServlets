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

@WebServlet(urlPatterns = "/admin/book/remove",name = "RemoveBookServlet")
public class RemoveBookServlet extends HttpServlet {
    private InMemoryBookStorage inMemoryBookStorage = InMemoryBookStorage.getInstance();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/pages/bookView.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Book book = inMemoryBookStorage.getById(Integer.parseInt(req.getParameter("id")));
        Author author = book.getAuthor();
        author.deleteBook(book);
        inMemoryBookStorage.removeBook(book.getId());
        resp.sendRedirect("/");

    }
}
