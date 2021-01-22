package servlets;

import model.Basket;
import model.Book;
import storage.InMemoryBookStorage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/user/basket", name = "BasketServlet")
public class BasketServlet extends HttpServlet {
    private InMemoryBookStorage inMemoryBookStorage = InMemoryBookStorage.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Book byId = inMemoryBookStorage.getById(Integer.parseInt(id));
        Basket basket = (Basket) req.getSession().getAttribute("basket");
        basket.addBook(byId);
        resp.sendRedirect("/book/view?id=" + id);
    }
}
