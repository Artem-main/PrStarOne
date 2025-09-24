package PersFinance.src.main.java.ru.productstar.servlets;

import PersFinance.src.main.java.ru.productstar.servlets.model.Expense;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class DetailsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var context = req.getServletContext();
        List<Transaction> transactions = (List<Transaction>) context.getAttribute("transactions");

        resp.getWriter().println("Transactions: ");
        for (Transaction t : transactions) {
            String type = t.isIncome() ? "Income" : "Expense";
            resp.getWriter().println(String.format("- %s: %s (%d)", type, t.getName(), t.getAmount()));
        }
        resp.getWriter().println("\n");
    }
}
