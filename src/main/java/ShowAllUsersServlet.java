import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/all")
public class ShowAllUsersServlet extends HttpServlet {
    private InMemoryStorage inMemoryStorage = new InMemoryStorage();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        if (user!=null){
            resp.getWriter().print("Users of system: \n");
            for (User u: inMemoryStorage.getUsers()){
                resp.getWriter().print("ID: "+u.getId()+", Name: "+u.getUserName()+", Login: "+u.getLogin()+".\n");
            }
        }else {
            resp.getWriter().print("Guests can't see users of the system!");
        }


    }
}
