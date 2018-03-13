package services.impl;

import model.dao.impl.UserDAO;
import model.dao.interfaces.IUserDAO;
import model.pojo.User;
import services.interfaces.IUserService;

public class UserService implements IUserService {
    private static IUserDAO userDAO = new UserDAO();

    @Override
    public boolean userExists(String username) {
        return userDAO.userExists(username);
    }

    @Override
    public User auth(String username, String password) {
        return userDAO.findUser(username, password);
    }

    @Override
    public boolean register(String username, String password) {
        return userDAO.save(new User(username, password)) != null;
    }
}