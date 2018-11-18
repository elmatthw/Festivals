package by.iba.training.controller;

import by.iba.training.entity.Place;
import by.iba.training.controller.exception.PlaceNotFoundException;
import by.iba.training.repository.EventRepository;
import by.iba.training.repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("places")
public class PlaceController {

    @Autowired
    private PlaceRepository placeRepository;

    @GetMapping("/")
    public List<Place> all(){
        return placeRepository.findAll();
    }

    @GetMapping("/{id}")
    public Place one(@PathVariable("id") Integer id){
        return placeRepository.findById(id)
                .orElseThrow(() -> new PlaceNotFoundException(id));
    }

    @PostMapping("/add-place")
    public Place addPlace(@RequestBody Place newPlace){
        return placeRepository.save(newPlace);
    }

    @DeleteMapping("/{id}/delete-place")
    public void deletePlace(@PathVariable("id") String id){
        placeRepository.deleteById(Integer.parseInt(id));
    }
}
