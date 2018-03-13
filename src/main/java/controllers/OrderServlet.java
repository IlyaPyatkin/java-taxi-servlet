package controllers;

import services.impl.OrderService;
import services.interfaces.IOrderService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

public class OrderServlet extends HttpServlet {
    private static Logger LOGGER = Logger.getLogger(OrderServlet.class.getName());
    private static IOrderService orderService = new OrderService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String username = (String) req.getSession().getAttribute("username");
        if (username == null)
            resp.sendRedirect("/");
        req.setAttribute("orders", orderService.getOrders(username));
        getServletContext().getRequestDispatcher("/dashboard.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String origin = req.getParameter("origin");
        String destination = req.getParameter("destination");
        String username = (String) req.getSession().getAttribute("username");
        if (orderService.create(username, origin, destination)) {
            resp.sendRedirect("ordered");
            LOGGER.info("New order created for " + username);
        } else
            resp.sendRedirect("error");
    }
}
