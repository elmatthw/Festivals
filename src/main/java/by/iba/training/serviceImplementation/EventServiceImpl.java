package by.iba.training.serviceImplementation;

import by.iba.training.entity.Event;
import by.iba.training.entity.PersonalInfo;
import by.iba.training.entity.User;
import by.iba.training.entity.UserOnEvent;
import by.iba.training.repository.*;
import by.iba.training.service.EventService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EventServiceImpl implements EventService{

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private PlaceRepository placeRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserOnEventRepository userOnEventRepository;

    public void saveEvent(Event event){
        event.getPlace().getEventSet().add(event);
        eventRepository.save(event);
    }

    @Override
    public List<Event> findAllUserEvents(String email) {
        User user = userRepository.findUserByEmail(email);
        List<Event> events = new ArrayList<>();
        List<UserOnEvent> userOnEventList = userOnEventRepository.findUserOnEventsByUser(user);
        for (UserOnEvent userOnEvent: userOnEventList) {
            events.add(userOnEvent.getEvent());
        }
        return events;
    }
}
