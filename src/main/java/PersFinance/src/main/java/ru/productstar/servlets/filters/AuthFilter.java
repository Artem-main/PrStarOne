package PersFinance.src.main.java.ru.productstar.servlets.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;

@WebFilter("/*")
public class AuthFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        // Список публичных URL
        String[] publicUrls = {"/login", "/error"};

        String currentUrl = req.getRequestURI();

        boolean isPublicUrl = Arrays.stream(publicUrls)
                .anyMatch(url -> currentUrl.contains(url));

        if (!isPublicUrl) {
            HttpSession session = req.getSession(false);
            if (session == null || !session.getAttribute("authenticated").equals(true)) {
                resp.sendRedirect("/login");
                return;
            }
        }

        chain.doFilter(request, response);
    }
}
