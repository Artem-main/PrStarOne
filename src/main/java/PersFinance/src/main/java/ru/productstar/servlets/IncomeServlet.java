package PersFinance.src.main.java.ru.productstar.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/incomes/add")
public class IncomeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var context = req.getServletContext();
        List<Transaction> transactions = (List<Transaction>) context.getAttribute("transactions");

        if (transactions == null) {
            transactions = new ArrayList<>();
            context.setAttribute("transactions", transactions);
        }

        String name = req.getParameter("name");
        int amount = Integer.parseInt(req.getParameter("amount"));

        transactions.add(new Transaction(name, amount, true));
        context.setAttribute("transactions", transactions);

        int freeMoney = (int) context.getAttribute("freeMoney");
        freeMoney += amount;
        context.setAttribute("freeMoney", freeMoney);

        resp.sendRedirect("/summary");
    }
}
