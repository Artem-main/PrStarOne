package PersFinance.src.main.java.ru.productstar.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/error")
public class ErrorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Exception exception = (Exception) req.getAttribute("javax.servlet.error.exception");
        String uri = (String) req.getAttribute("javax.servlet.error.request_uri");
        int status = (int) req.getAttribute("javax.servlet.error.status_code");

        resp.setContentType("text/plain");

        if (status == 404) {
            resp.getWriter().println("Error (404) — page not found");
        } else {
            String errorMessage = exception.getMessage() != null ? exception.getMessage() : "";
            resp.getWriter().println(String.format("Error (%d) — %s: %s",
                    status,
                    exception.getClass().getSimpleName(),
                    errorMessage));
        }
    }
}
