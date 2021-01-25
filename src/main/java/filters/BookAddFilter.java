package filters;

import storage.InMemoryBookStorage;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Pattern;

@WebFilter(servletNames = {"AddNewBookServlet"})
public class BookAddFilter extends HttpFilter {
    private InMemoryBookStorage inMemoryBookStorage = InMemoryBookStorage.getInstance();

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        req.setCharacterEncoding("UTF-8");
        boolean isAdmin = (boolean) req.getSession().getAttribute("isAdmin");
        if (isAdmin) {
            if (req.getMethod().equals("POST")) {
                Pattern yearPattern = Pattern.compile("\\d{4}");
                Pattern pricePattern = Pattern.compile("(\\d){1,4}\\.(\\d{2})");
                Pattern namePattern = Pattern.compile("(\\p{Upper}\\p{Lower}+\\s*)+");
                Pattern textPattern = Pattern.compile("([а-яёА-ЯЁ]*|\\w*\\s*|\\p{Punct}*\\s*)+");
                Pattern urlPattern = Pattern.compile("[http://]+");

                String title = req.getParameter("title");
                String info = req.getParameter("info");
                String authorName = req.getParameter("authorName");
                String authorSurname = req.getParameter("authorSurname");
                String yearOfPublishing = req.getParameter("year");
                String price = req.getParameter("price");
                String url = req.getParameter("url");
                if (textPattern.matcher(title).matches()) {
                    if (inMemoryBookStorage.getByTitle(title) == null) {
                        if (namePattern.matcher(authorName).matches() && namePattern.matcher(authorSurname).matches()) {
                            if (textPattern.matcher(info).find()) {
                                if (yearPattern.matcher(yearOfPublishing).matches()) {
                                    if (pricePattern.matcher(price).matches()) {
                                        if (urlPattern.matcher(url).find()) {
                                            chain.doFilter(req, res);
                                        } else {
                                            req.setAttribute("result", "The photo's url can't be empty!");
                                            getServletContext().getRequestDispatcher("/pages/addNewBook.jsp").forward(req, res);
                                        }
                                    } else {
                                        req.setAttribute("result", "The price has wrong format!");
                                        getServletContext().getRequestDispatcher("/pages/addNewBook.jsp").forward(req, res);
                                    }
                                } else {
                                    req.setAttribute("result", "The year has wrong format!");
                                    getServletContext().getRequestDispatcher("/pages/addNewBook.jsp").forward(req, res);
                                }
                            } else {
                                req.setAttribute("result", "The book's description has wrong format!");
                                getServletContext().getRequestDispatcher("/pages/addNewBook.jsp").forward(req, res);
                            }
                        } else {
                            req.setAttribute("result", "The author's name or surname has wrong format!");
                            getServletContext().getRequestDispatcher("/pages/addNewBook.jsp").forward(req, res);
                        }

                    } else {
                        req.setAttribute("result", "The shop has book with the same title!");
                        getServletContext().getRequestDispatcher("/pages/addNewBook.jsp").forward(req, res);
                    }
                } else {
                    req.setAttribute("result", "The title has wrong format!");
                    getServletContext().getRequestDispatcher("/pages/addNewBook.jsp").forward(req, res);
                }

            } else {
                chain.doFilter(req, res);
            }
        } else {
            res.sendRedirect("/");
        }
    }
}
