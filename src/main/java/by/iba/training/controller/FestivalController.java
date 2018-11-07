package by.iba.training.controller;

import by.iba.training.connector.DBWorker;
import by.iba.training.entity.Event;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/fests")
public class FestivalController {


    @RequestMapping("/events")
    public String getEvents(Model model){
        List<Event> events = DBWorker.getEventList();
        model.addAttribute("events", events);
        return "events";
    }

    @RequestMapping(value = "/events/add/{id}")
    @ResponseBody
    public List<Event> addParticipant(@PathVariable Integer id){
        DBWorker.addParticipant(id);
        return DBWorker.getEventList();
    }

    /*@PostMapping("/events")
    public Event save(@RequestBody Event e){
        return eventService.save(e);
    }

    @GetMapping("/events")
    public ResponseEntity<Object> getAll(){
        return ResponseEntity.ok().body(eventService.getAllEvents());
    }

    @GetMapping("/events/{id}")
    public ResponseEntity<Object> updateEvent(@PathVariable(value = "id") Integer id, @RequestBody Event e) {
        e.setId(id);
        Event event = eventService.updateEvent(e);
        if (event == null) {
            return ResponseEntity.ok().body(new String("Not original"));
        }
        return ResponseEntity.ok().body(event);
    }*/

}
