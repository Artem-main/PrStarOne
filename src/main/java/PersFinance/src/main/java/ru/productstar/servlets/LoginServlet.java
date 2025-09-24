package PersFinance.src.main.java.ru.productstar.servlets;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    private final String passwordCred = "123456";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String password = req.getParameter("password");

        if (passwordCred.equals(password)) {
            HttpSession session = req.getSession();
            session.setAttribute("authenticated", true);
            resp.sendRedirect("/summary");
        } else {
            resp.getWriter().println("Wrong password");
        }
    }
}
