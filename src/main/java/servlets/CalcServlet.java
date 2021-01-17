package servlets;

import model.Calculator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(urlPatterns = "/user/calc", name = "CalcServlet")
public class CalcServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/pages/calculator.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int numOne = Integer.parseInt(req.getParameter("num1"));
        int numTwo = Integer.parseInt(req.getParameter("num2"));
        String sign = req.getParameter("sign");
        req.setAttribute("result",new Calculator().calculate(numOne,numTwo,sign));
        getServletContext().getRequestDispatcher("/pages/calculator.jsp").forward(req,resp);
    }
}



