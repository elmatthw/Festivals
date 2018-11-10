package by.iba.training.controller;

import by.iba.training.entity.Event;
import by.iba.training.repository.EventRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/events")
public class FestivalController {

    @Autowired
    private EventRepository repository;

    @GetMapping("/")
    @ApiOperation("Return fests")
    public List<Event> findAll(){
        return repository.findAll();
    }

    @GetMapping("/add-event")
    public List<Event> addEvent(){
        return null;
    }

    @GetMapping("/{id}")
    public Event show(@PathVariable String id){
        Integer eventId = Integer.parseInt(id);
        return repository.findById(eventId).get();
    }

    @RequestMapping("{id}/add-participant")
    public List<Event> addParticipant(@PathVariable("id") String id){
        List<Event> events = repository.findAll();
        for (Event event: events) {
            if(event.getId() == Integer.parseInt(id)) {
                event.setCurrentNumberOfParticipants(event.getCurrentNumberOfParticipants() + 1);
                repository.save(event);
                break;
            }
        }
        return findAll();
    }

}
