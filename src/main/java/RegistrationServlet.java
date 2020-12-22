import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Pattern;

@WebServlet(urlPatterns = "/reg")
public class RegistrationServlet extends HttpServlet {
    private InMemoryStorage inMemoryStorage = new InMemoryStorage();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Pattern pattern = Pattern.compile("\\w+");
        String userName = req.getParameter("name");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        if (userName != null && login != null && password != null) {
            if (userName.matches("(\\p{Upper}?)(\\p{Lower}+)") && pattern.matcher(userName).matches() &&
                    pattern.matcher(password).matches()) {
                if (inMemoryStorage.getUserByLogin(login) == null) {
                    User user = new User(userName, login, password);
                    inMemoryStorage.saveUser(user);
                    resp.getWriter().print("Registration passed successful!");
                } else {
                    resp.getWriter().print("User with this login already exists!");
                }
            } else {
                resp.getWriter().print("Wrong symbols for login or password or user's name!");
            }
        } else {
            resp.getWriter().print("Name, login or password field can't be empty!");
        }
    }
}
