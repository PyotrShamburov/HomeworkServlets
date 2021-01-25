package filters;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(servletNames = {"RemoveBookServlet","AuthorRemoveServlet"})
public class BookNAuthorRemoveFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        boolean isAdmin = (boolean) req.getSession().getAttribute("isAdmin");
        if (isAdmin) {
            if (req.getMethod().equals("POST")) {
                chain.doFilter(req, res);
            } else {
                res.sendRedirect("/");
            }
        } else {
            res.sendRedirect("/");
        }
    }
}
