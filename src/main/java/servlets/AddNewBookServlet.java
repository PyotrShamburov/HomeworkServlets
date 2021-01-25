package servlets;

import com.sun.xml.internal.bind.v2.runtime.output.Encoded;
import model.Author;
import model.Book;
import org.omg.IOP.Encoding;
import storage.InMemoryAuthorStorage;
import storage.InMemoryBookStorage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.Formatter;

@WebServlet(urlPatterns = "/admin/book/add", name = "AddNewBookServlet")
public class AddNewBookServlet extends HttpServlet {
    private InMemoryBookStorage inMemoryBookStorage = InMemoryBookStorage.getInstance();
    private InMemoryAuthorStorage inMemoryAuthorStorage = InMemoryAuthorStorage.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/pages/addNewBook.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        String info = req.getParameter("info");
        String authorName = req.getParameter("authorName");
        String authorSurname = req.getParameter("authorSurname");
        int yearOfPublishing = Integer.parseInt(req.getParameter("year"));
        double price = Double.parseDouble(req.getParameter("price"));
        String url = req.getParameter("url");
        Author author = inMemoryAuthorStorage.getByName(authorName, authorSurname);
        Book book ;
        if (author != null) {
            book = new Book(title, info, author, yearOfPublishing, price, url);
            author.setBooks(book);
        } else {
            book = new Book(title, info, yearOfPublishing, price, url);
        }
        inMemoryBookStorage.saveBook(book);
        req.setAttribute("book",book);
        getServletContext().getRequestDispatcher("/pages/bookView.jsp").forward(req,resp);

    }
}
