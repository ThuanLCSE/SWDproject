package swd.service;

import java.util.List;

import swd.entity.model.User;

public interface UserService {
    public List<User> getAllUser();
    public void signUp(String username, String password, String fullName);
}
