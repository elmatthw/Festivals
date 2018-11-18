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
    UserRepository userRepository;

    @Autowired
    PersonalInfoRepository personalInfoRepository;

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
        System.out.println(user.getUsername());
        PersonalInfo personalInfo = new PersonalInfo();
        personalInfo.getStatuses().add(statusRepository.findById(2).get());
        personalInfo.setUserAuthorization(user);
        personalInfoRepository.save(personalInfo);
        user.setPersonalInfo(personalInfo);
        userRepository.save(user);
    }
}
