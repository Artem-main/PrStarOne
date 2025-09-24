package PersFinance.src.main.java.ru.productstar.servlets;


import PersFinance.src.main.java.ru.productstar.servlets.model.Expense;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SummaryServlet extends HttpServlet {
    @Override
    public void init(ServletConfig config) throws ServletException {
        var context = config.getServletContext();
        var salary = Integer.valueOf(context.getInitParameter("salary"));
        var rent = Integer.valueOf(config.getInitParameter("rent"));

        context.setAttribute("freeMoney", salary - rent);
        context.setAttribute("transactions", new ArrayList<Transaction>() {{
            add(new Transaction("rent", rent, false));
        }});
        context.log("SummaryServlet Init");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var context = req.getServletContext();
        var session = req.getSession(false);

        if (session == null || !session.getAttribute("authenticated").equals(true)) {
            resp.getWriter().println("Not authorized");
            return;
        }

        List<Transaction> transactions = (List<Transaction>) context.getAttribute("transactions");
        int freeMoney = (int) context.getAttribute("freeMoney");

        resp.getWriter().println("Transactions:");
        for (Transaction t : transactions) {
            String type = t.isIncome() ? "Income" : "Expense";
            resp.getWriter().println(String.format("- %s: %s (%d)", type, t.getName(), t.getAmount()));
        }

        resp.getWriter().println("\nFree money: " + freeMoney);
    }
}
