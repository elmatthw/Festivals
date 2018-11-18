package by.iba.training.service;



import by.iba.training.entity.Event;

import java.util.List;

public interface EventService {
    List<Event> addParticipant(Integer id);
    void saveEvent(Event event);
}
