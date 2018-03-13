package controllers;

import services.impl.UserService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

public class RegisterServlet extends HttpServlet {
    private static Logger LOGGER = Logger.getLogger(RegisterServlet.class.getName());
    private static UserService userService = new UserService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        resp.setContentType("text/html");

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        try {
            boolean isRegistered = userService.userExists(username);

            if (!isRegistered && userService.register(username, password)) {
                req.getSession().setAttribute("username", username);
                LOGGER.info("New user: " + username);
                resp.sendRedirect("order");
            } else
                resp.sendRedirect("error");
        } catch (IOException e) {
            LOGGER.warning("Error registering user: " + e.getMessage());
        }
    }
}
