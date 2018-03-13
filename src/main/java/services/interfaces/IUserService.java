package services.interfaces;

import model.pojo.User;

public interface IUserService {
    boolean userExists(String username);

    User auth(String username, String password);

    boolean register(String name, String password);
}
