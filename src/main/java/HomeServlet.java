import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/")
public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user =(User) req.getSession().getAttribute("user");
        if (user!= null){
            resp.getWriter().print("Hello, "+user.getUserName().toUpperCase()+" !\n" +
                    "You can do follow requests: \n" +
                    "1.\"\\account\" - for information about your profile.\n" +
                    "2.\"\\all\" - show all users of this system.\n" +
                    "3.\"\\out\" - exit from your profile and continue like a guest.");
        }else{
            resp.getWriter().print("Hello, GUEST!\n" +
                    "You can do follow requests: \n" +
                    "1.\"\\reg\" - create your profile in the system.\n" +
                    "2.\"\\enter\" - pass a authorisation, if you have registered profile earlier \n" +
                    "and you can continue like a user.");
        }

    }
}
