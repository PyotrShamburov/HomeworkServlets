import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Pattern;

@WebServlet(urlPatterns = "/enter")
public class AuthorisationServlet extends HttpServlet {
    private InMemoryStorage inMemoryStorage = new InMemoryStorage();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Pattern pattern = Pattern.compile("\\w+");
        String login = req.getParameter("login").trim();
        String password = req.getParameter("password").trim();
        User user = inMemoryStorage.getUserByLogin(login);
        if (pattern.matcher(login).matches() && pattern.matcher(password).matches()) {
            if (user != null) {
                if (user.getPassword().equals(password)) {
                    req.getSession().setAttribute("user", user);
                    resp.getWriter().print("Authorisation passed successful!");
                } else {
                    resp.getWriter().print("Your password is wrong!");
                }
            } else {
                resp.getWriter().print("User with this login doesn't exist!");
            }
        }else{
            resp.getWriter().print("Wrong symbols for login or password!");
        }
    }
}
