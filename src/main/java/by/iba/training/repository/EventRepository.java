package by.iba.training.repository;

import by.iba.training.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {


    List<Event> loadEvents();

    List<Event> findEventByEventName(@Param("eventName") String eventName);

    Event findEventById(@Param("id") Integer id);

    /*public Map<Integer, Event> loadEvents() {
        Map<Integer, Event> events = new HashMap<>();

        events.put(1, new Event(
                какие - то данные
        ));
        return events;
    }

    public Map<Integer, Performer> loadPerformers() {
        Map<Integer, Performer> performers = new HashMap<>();

        performers.put(1, new Performer());
        return performers;
    }*/

}
