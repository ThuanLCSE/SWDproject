package swd.business.service;

import java.util.List;

import swd.persistence.entity.model.User;

public interface UserService {
    public final String regExPatternUsername = ".{6,40}";
    public final String regExPatternPassword = ".{6,40}";
    public final String regExPatternFullname = ".{4,60}";
    
    public List<User> getAllUser();
    public User getUserById(int userId);
    public boolean getAuthenticated(String username, String password);
    public User getAuthorized(String username);
    public boolean signUp(String username, String password, String fullName);
}
