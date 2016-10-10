package swd.persistence.DAO;

import java.util.List;


import swd.persistence.entity.model.User;

public interface UserRepository {
    public boolean checkLogin(String username, String password);

    public boolean updateInfo(User user);
    public boolean usernameExist(String username);
    public boolean create(User user);

    public boolean deactivate(int userId);

    public User getById(int userId);
    public User getByUsername(String username);

    public List<User> getAll() ;
}
