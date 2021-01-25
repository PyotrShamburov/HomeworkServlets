package servlets;

import storage.InMemoryAuthorStorage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/authors")
public class ShowAllAuthorsServlet extends HttpServlet {
     private InMemoryAuthorStorage inMemoryAuthorStorage = InMemoryAuthorStorage.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("authors",inMemoryAuthorStorage.getWriters());
        getServletContext().getRequestDispatcher("/pages/allAuthors.jsp").forward(req,resp);
    }
}
