package filters;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(servletNames = {"BookView","AuthorViewServlet"})
public class BookViewFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        if (req.getMethod().equals("GET")) {
            String id = req.getParameter("id");
            if (id.matches("\\d+")) {
                chain.doFilter(req,res);
            } else {
                res.sendRedirect("/");
            }
        } else {
            chain.doFilter(req, res);
        }
    }

}
