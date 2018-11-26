package by.iba.training.service;


import by.iba.training.entity.Event;

import java.util.List;

public interface EventService {
    void saveEvent(Event event);
    List<Event> findAllUserEvents(String email);
}
