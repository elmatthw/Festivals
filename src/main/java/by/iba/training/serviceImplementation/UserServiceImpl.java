package by.iba.training.serviceImplementation;

import by.iba.training.entity.PersonalInfo;
import by.iba.training.entity.User;
import by.iba.training.repository.PersonalInfoRepository;
import by.iba.training.repository.StatusRepository;
import by.iba.training.repository.UserRepository;
import by.iba.training.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PersonalInfoRepository personalInfoRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private StatusRepository statusRepository;

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setUserStatus(statusRepository.findById(2).get());
        userRepository.save(user);
        PersonalInfo personalInfo = new PersonalInfo();
        personalInfo.setUserAuthorization(user);
        user.setPersonalInfo(personalInfo);
        personalInfoRepository.save(personalInfo);
        userRepository.save(user);
    }
}
