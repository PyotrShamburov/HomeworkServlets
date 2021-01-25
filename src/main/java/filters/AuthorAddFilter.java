package filters;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Pattern;

@WebFilter(servletNames = {"AddNewAuthorServlet"})
public class AuthorAddFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        req.setCharacterEncoding("UTF-8");
        boolean isAdmin = (boolean) req.getSession().getAttribute("isAdmin");
        if (isAdmin){
            if (req.getMethod().equals("POST")){
                Pattern namePattern = Pattern.compile("(\\p{Upper}\\p{Lower}+\\s*)+");
                Pattern textPattern = Pattern.compile("([а-яёА-ЯЁ]*|\\w*\\s*|\\p{Punct}*\\s*)+");
                Pattern urlPattern = Pattern.compile("[http://]+");

                String firstName = req.getParameter("name");
                String lastName = req.getParameter("surname");
                String bio = req.getParameter("bio");
                String urlPhoto = req.getParameter("url");
                if (namePattern.matcher(firstName).matches() && namePattern.matcher(lastName).matches()){
                    if (textPattern.matcher(bio).find()){
                        if (urlPattern.matcher(urlPhoto).find()){
                            chain.doFilter(req,res);
                        }else{
                            req.setAttribute("result","The photo's url has wrong format!");
                            getServletContext().getRequestDispatcher("/pages/addNewAuthor.jsp").forward(req,res);
                        }
                    }else {
                        req.setAttribute("result","The author's description has wrong format!");
                        getServletContext().getRequestDispatcher("/pages/addNewAuthor.jsp").forward(req,res);
                    }
                }else{
                    req.setAttribute("result","The author's name or surname has wrong format!");
                    getServletContext().getRequestDispatcher("/pages/addNewAuthor.jsp").forward(req,res);
                }
            }else{
                chain.doFilter(req,res);
            }
        }else{
            res.sendRedirect("/");
        }
    }
}
