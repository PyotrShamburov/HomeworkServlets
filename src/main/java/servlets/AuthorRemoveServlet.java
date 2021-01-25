package servlets;

import model.Author;
import storage.InMemoryAuthorStorage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/admin/author/remove",name = "AuthorRemoveServlet")
public class AuthorRemoveServlet extends HttpServlet {

    private InMemoryAuthorStorage inMemoryAuthorStorage = InMemoryAuthorStorage.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Author author = inMemoryAuthorStorage.getById(Integer.parseInt(req.getParameter("id")));
        if (author.getBooks().size() == 0){
            inMemoryAuthorStorage.removeAuthor(author.getId());
            resp.sendRedirect("/");
        }else{
            resp.sendRedirect("/author/view?id=" + author.getId());
        }

    }
}
