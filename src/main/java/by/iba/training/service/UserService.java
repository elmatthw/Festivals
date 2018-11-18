package by.iba.training.service;

import by.iba.training.entity.User;

public interface UserService {
    User findUserByEmail(String email);
    User findByUsername(String username);
    void saveUser(User user);
}
