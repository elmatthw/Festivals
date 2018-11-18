package by.iba.training.serviceImplementation;

import by.iba.training.entity.PersonalInfo;
import by.iba.training.repository.EventRepository;
import by.iba.training.repository.PersonalInfoRepository;
import by.iba.training.repository.StatusRepository;
import by.iba.training.repository.UserRepository;
import by.iba.training.service.PersonalInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonalInfoServiceImpl implements PersonalInfoService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private UserRepository userRepository;

    private PersonalInfoRepository personalInfoRepository;

    @Autowired
    private StatusRepository statusRepository;

    public PersonalInfo findById(Integer id){
        return personalInfoRepository.findById(id).get();
    }
}
