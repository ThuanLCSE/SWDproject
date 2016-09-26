package swd.business.service;

import java.util.List;

import swd.persistence.entity.model.User;

public interface UserService {
    public List<User> getAllUser();
    public boolean getAuthenticated(String username, String password);
    public User getAuthorized(String username);
    public boolean signUp(String username, String password, String fullName);
}
