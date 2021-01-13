package servlets;

import model.User;
import storage.InMemoryStorage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(urlPatterns = "/all")
public class ShowAllUsersServlet extends HttpServlet {
    private InMemoryStorage inMemoryStorage = new InMemoryStorage();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        String users = "";
        if (user!=null){
               for (User u: inMemoryStorage.getUsers()){
                   users+=("ID: " +u.getId()+", Name: " +u.getUserName()+", Login: " +u.getLogin()+".<br>");
               }
               req.setAttribute("result",users);
                getServletContext().getRequestDispatcher("/pages/users.jsp").forward(req,resp);
        }else {
            req.setAttribute("result","Guests can't see users of the system!");
            getServletContext().getRequestDispatcher("/pages/users.jsp").forward(req,resp);
        }



    }
}
