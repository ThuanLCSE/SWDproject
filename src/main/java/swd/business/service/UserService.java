package swd.business.service;

import java.util.List;

import swd.persistence.entity.model.Publishedblog;
import swd.persistence.entity.model.User;
import swd.presentation.DTO.BlogDTO;
import swd.presentation.DTO.UserDTO;

public interface UserService {
    public final String regExPatternUsername = ".{6,40}";
    public final String regExPatternPassword = ".{6,40}";
    public final String regExPatternFullname = ".{4,60}";
    
    public List<User> getAllUser();
    public User getUserById(int userId);
    public boolean editUserById(int userId, User userEnt);
    public boolean deactiveUser(int userId);
    public boolean getAuthenticated(String username, String password);
    public User getAuthorized(String username);
    public boolean signUp(String username, String password, String fullName);
    public UserDTO convertToDTO(User userEnt);
    public User convertToEnt(UserDTO userDto);
}
