package filters;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Pattern;

@WebFilter(servletNames = {"CalcServlet"})
public class CalculatorFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        boolean isUser = (boolean) req.getSession().getAttribute("isUser");
        if (isUser){
            if (req.getMethod().equals("POST")){
                Pattern pattern = Pattern.compile("(\\-?)(\\d+)");
                String num1 = req.getParameter("num1");
                String num2 = req.getParameter("num2");
                String sign = req.getParameter("sign");
                if (pattern.matcher(num1).matches() && pattern.matcher(num2).matches() && sign.matches("\\p{Lower}{3}") ){
                    chain.doFilter(req,res);
                }else{
                    req.setAttribute("result", "Numbers should have digit format and field can't be empty!");
                    getServletContext().getRequestDispatcher("/pages/calculator.jsp").forward(req, res);
                }
            }else{
                chain.doFilter(req,res);
            }
        }else{
            res.sendRedirect("/");
        }
    }
}
