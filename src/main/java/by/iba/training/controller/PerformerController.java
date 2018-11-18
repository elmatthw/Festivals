package by.iba.training.controller;

import by.iba.training.entity.Event;
import by.iba.training.entity.Performer;
import by.iba.training.repository.EventRepository;
import by.iba.training.repository.PerformerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/performers")
public class PerformerController {

    @Autowired
    PerformerRepository performerRepository;

    @Autowired
    EventRepository eventRepository;

    @GetMapping("/{id}")
    public Performer one(@PathVariable("id") Integer id){
        return performerRepository.findById(id).get();
    }

    @PostMapping("/new-performer")
    public Performer addPerformer(@RequestBody Performer newPerformer){
        return performerRepository.save(newPerformer);
    }

    @DeleteMapping("/{id}/delete-performer")
    public void delete(@PathVariable("id") Integer id){
        performerRepository.deleteById(id);
    }
}
