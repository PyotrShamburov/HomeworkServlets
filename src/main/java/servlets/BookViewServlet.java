package servlets;

import model.Book;
import storage.InMemoryBookStorage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/book/view", name = "BookView")
public class BookViewServlet extends HttpServlet {

    private InMemoryBookStorage inMemoryBookStorage = InMemoryBookStorage.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Book id = inMemoryBookStorage.getById(Integer.parseInt(req.getParameter("id")));
        req.setAttribute("book",id);
        getServletContext().getRequestDispatcher("/pages/bookView.jsp").forward(req,resp);
    }
}
