/*
package by.iba.training.serviceImplementation;

import by.iba.training.repository.EventRepository;
import by.iba.training.service.EventService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EventServiceImpl implements EventService {


    @Autowired
    EventRepository eventRepository;

    @Override
    public Event save(Event e) {
        by.iba.training.entity.Event outEvent2 = new by.iba.training.entity.Event();
        BeanUtils.copyProperties(e, outEvent2);
        outEvent2 = eventRepository.save(outEvent2);
        BeanUtils.copyProperties(outEvent2, e);
        return e;
    }

    @Override
    public List<Event> getAllEvents() {
        List<by.iba.training.entity.Event> allEvents = eventRepository.findAll();
        List<Event> outList = new ArrayList<>();
        for (by.iba.training.entity.Event events: allEvents) {
            Event event = new Event();
            BeanUtils.copyProperties(events, event);
            outList.add(event);
            
        }

        return outList ;
    }

    @Override
    public Event updateEvent(Event e) {
        by.iba.training.entity.Event dbEvent = eventRepository.findEventById(e.getId());
        if(dbEvent!=null){
            dbEvent.setEventName(e.getEventName());
            dbEvent.setDate(e.getDate());
            dbEvent.setDeadlineDate(e.getDeadlineDate());
            dbEvent.setPlace(e.getPlace());
            dbEvent.setEventType(e.getEventType());
            dbEvent.setUser(e.getUser());
            dbEvent.setSummary(e.getSummary());
            dbEvent.setListOfParticipants(e.getListOfParticipants());
            dbEvent.setListOfPerformers(e.getListOfPerformers());
            eventRepository.save(dbEvent);
            BeanUtils.copyProperties(dbEvent, e);
            return e;
        }
        else
            return null;
    }

    @Override
    public Event findById(int id) {
        return null;
    }
}
*/
