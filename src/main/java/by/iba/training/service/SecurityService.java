package by.iba.training.service;

public interface SecurityService {

    String findLoggedInUsername();
    void autologin(String username, String password);
}
