package servlets;

import model.Author;
import storage.InMemoryAuthorStorage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/admin/author/add",name = "AddNewAuthorServlet")
public class AddNewAuthorServlet extends HttpServlet {
    private InMemoryAuthorStorage inMemoryAuthorStorage = InMemoryAuthorStorage.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/pages/addNewAuthor.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("name");
        String lastName = req.getParameter("surname");
        String bio = req.getParameter("bio");
        String urlPhoto = req.getParameter("url");
        if (inMemoryAuthorStorage.getByName(firstName,lastName)==null){
            Author author = new Author(firstName,lastName,bio,urlPhoto);
            inMemoryAuthorStorage.saveAuthor(author);
            req.setAttribute("author",author);
            getServletContext().getRequestDispatcher("/pages/authorView.jsp").forward(req,resp);
        }else{
            req.setAttribute("result","Author with same name and surname yet exists!");
            getServletContext().getRequestDispatcher("/pages/addNewAuthor.jsp").forward(req,resp);
        }


    }
}
