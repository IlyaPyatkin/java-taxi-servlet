package controllers;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

public class LogoutServlet extends HttpServlet {
    private static Logger LOGGER = Logger.getLogger(LogoutServlet.class.getName());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String username = (String) req.getSession().getAttribute("username");
        req.getSession().invalidate();
        LOGGER.info(username + " has successfully logged out.");
        resp.sendRedirect("index.jsp");
    }
}
