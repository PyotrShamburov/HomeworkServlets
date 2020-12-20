import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/account")
public class AccountServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        if (user!=null){
            resp.getWriter().print("Your personal data: \n"+user.toString());
        }else{
            resp.getWriter().print("Your status is Guest! If you want to see your \n" +
                    "account's info, please, pass authorisation!");
        }
    }
}
