package filters;


import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Pattern;

@WebFilter(servletNames = {"RegistrationServlet", "AuthorisationServlet"})
public class AccountFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        boolean isGuest = (boolean) req.getSession().getAttribute("isGuest");
        if (isGuest){
             if (req.getMethod().equals("POST")){
                Pattern pattern = Pattern.compile("\\w{3,15}");
                Pattern patternName = Pattern.compile("(\\p{Upper}?)(\\p{Lower}{3,15})");
                String userName = req.getParameter("name");
                String login = req.getParameter("login");
                String password = req.getParameter("password");
                if (userName == null) {
                    if (pattern.matcher(login).matches() && pattern.matcher(password).matches()) {
                        chain.doFilter(req, res);
                    } else {
                        req.setAttribute("result", "Wrong symbols for login or password!");
                        getServletContext().getRequestDispatcher("/pages/authorisation.jsp").forward(req, res);
                    }
                } else {
                    if (patternName.matcher(userName).matches() && pattern.matcher(login).matches() &&
                            pattern.matcher(password).matches()) {
                        chain.doFilter(req, res);
                    } else {
                        req.setAttribute("result", "Wrong symbols for login or password or user's name!\n" +
                                "Their fields can't be empty and must have length from 3 to 15 symbols!");
                        getServletContext().getRequestDispatcher("/pages/registration.jsp").forward(req, res);
                    }
                }
            } else {
                 chain.doFilter(req,res);
            }
        }else{
            res.sendRedirect("/");
        }
    }
}
