package controllers;

import model.pojo.User;
import services.impl.UserService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

public class LoginServlet extends HttpServlet {
    private static Logger LOGGER = Logger.getLogger(LoginServlet.class.getName());
    private static UserService userService = new UserService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        resp.setContentType("text/html");

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        try {
            User user = userService.auth(username, password);
            if (user != null) {
                LOGGER.info(username + " has successfully logged in.");
                req.getSession().setAttribute("username", username);
                resp.sendRedirect("order");
            } else
                resp.sendRedirect("error");
        } catch (IOException e) {
            LOGGER.warning(e.getMessage());
        }
    }
}
