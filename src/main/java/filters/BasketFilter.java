package filters;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(servletNames = {"BasketServlet"})
public class BasketFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        if (req.getSession().getAttribute("user") != null) {
            if (req.getMethod().equals("GET")){
                res.sendRedirect("/");
            }else{
                chain.doFilter(req,res);
            }
        } else {
            res.sendRedirect("/");
        }
    }
}
