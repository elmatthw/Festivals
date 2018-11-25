package by.iba.training.serviceImplementation;

import by.iba.training.entity.Event;
import by.iba.training.entity.PersonalInfo;
import by.iba.training.repository.EventRepository;
import by.iba.training.repository.PerformerRepository;
import by.iba.training.repository.PlaceRepository;
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
    private PerformerRepository performerRepository;


    public void saveEvent(Event event){
        event.getPlace().getEventSet().add(event);
        eventRepository.save(event);
    }
}
