package by.iba.training.controller;

import by.iba.training.entity.Event;
import by.iba.training.entity.Performer;
import by.iba.training.entity.PerformerOnEvent;
import by.iba.training.repository.EventRepository;
import by.iba.training.repository.PerformerRepository;
import by.iba.training.repository.PlaceRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/events")
public class EventController {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private PlaceRepository placeRepository;

    @Autowired
    private PerformerRepository performerRepository;

    @RequestMapping(method = RequestMethod.GET)
    //@ApiOperation("Return fests")
    public String all(ModelMap model){
        //List<Event> events = eventRepository.findAll();
        model.addAttribute("events", eventRepository.findAll());
        return "events";
    }

    @PostMapping("/create-event")
    public Event createEvent(@RequestBody Event event){
        event.setPlace(placeRepository.save(event.getPlace()));
        return eventRepository.save(event);
    }

    @PostMapping("/create-event/add-performers")
    public Event addPerformers(@RequestBody PerformerOnEvent performerOnEvent){
        Event e = performerOnEvent.getEvent();
        Performer p = performerOnEvent.getPerformer();
        e.getListOfPerformers().add(p);
        p.getListOfEvents().add(e);
        performerRepository.save(p);
        return eventRepository.save(e);
    }

    @GetMapping("/{id}")
    public Event one(@PathVariable String id){
        Integer eventId = Integer.parseInt(id);
        return eventRepository.findById(eventId).get();
    }

    /*@GetMapping("/{id}/performers")
    public List<Performer> allPerformersOnEvent(@PathVariable("id") Integer id){
        return eventRepository.fin
    }*/


    @PutMapping("/{id}/replace-event")
    public Event replaceEvent(@RequestBody Event newEvent, @PathVariable("id") Integer id){
        return eventRepository.findById(id)
                .map(event -> {
                    event.setEventName(newEvent.getEventName());
                    event.setEventType(newEvent.getEventType());
                    event.setDate(newEvent.getDate());
                    event.setDeadlineDate(newEvent.getDeadlineDate());
                    event.setPlace(newEvent.getPlace());
                    event.setSummary(newEvent.getSummary());
                    return eventRepository.save(event);
                })
                .orElseGet(() -> {
                    newEvent.setId(id);
                    return eventRepository.save(newEvent);
                });
    }

    /*@GetMapping("{id}/add-participant")
    public List<Event> addParticipant(@PathVariable("id") String id){

        List<Event> events = eventRepository.findAll();
        for (Event event: events) {
            if(event.getId() == Integer.parseInt(id)) {
                event.setCurrentNumberOfParticipants(event.getCurrentNumberOfParticipants() + 1);
                eventRepository.save(event);
                break;
            }
        }
        return all();
    }*/

    @DeleteMapping("/{id}/delete-event")
    public void deleteEvent(@PathVariable("id") String id){
        eventRepository.deleteById(Integer.parseInt(id));
    }
}
