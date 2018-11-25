package by.iba.training.controller;

import by.iba.training.entity.*;
import by.iba.training.repository.*;
import by.iba.training.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.jws.soap.SOAPBinding;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/events")
public class EventController {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private EventService eventService;

    @Autowired
    private PlaceRepository placeRepository;

    @Autowired
    private PerformerRepository performerRepository;

    @Autowired
    private EventTypeRepository eventTypeRepository;

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String all(ModelMap model){
        model.addAttribute("events", eventRepository.findAll());
        return "/events";
    }

    @InitBinder
    public final void initBinderUsuariosFormValidator(final WebDataBinder binder, final Locale locale) {
        final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", locale);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @RequestMapping(value = "/admin/create-event", method = RequestMethod.GET)
    public String createEvent(Model model) {
        model.addAttribute("eventForm", new Event());

        return "/events/admin/create-event";
    }

    @RequestMapping(value = "/admin/create-event", method = RequestMethod.POST)
    public String createEvent(@ModelAttribute("eventForm") Event eventForm,
                              BindingResult bindingResult,
                              Model model) {
        //userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "/events/admin/create-event";
        }
        Place place = placeRepository.findByPlaceNameEquals(eventForm.getPlaceName());
        EventType eventType = eventTypeRepository.findByType(eventForm.getType());

        eventForm.setPlace(place);
        eventForm.setEventType(eventType);

        place.getEventSet().add(eventForm);

        eventRepository.save(eventForm);

        return "redirect:/events";
    }


    @RequestMapping("/admin/show-event/add-performer")
    public String addPerformers(@RequestParam("id") String id, Model model){
        List<Performer> performerList = performerRepository.findAll();
        model.addAttribute("performerList", performerList);

        return "/events/admin/show-event/add-performer";
    }

    @RequestMapping(value = "/admin/show-event/add-performer", method = RequestMethod.POST)
    public String createEvent(@RequestParam("id") String id,
                              @ModelAttribute("performer") Performer selectedPerformer,
                              BindingResult bindingResult,
                              Model model) {
        //userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            List<FieldError> errors = bindingResult.getFieldErrors();
            for (FieldError error : errors ) {
                System.out.println (error.getObjectName() + " - " + error.getDefaultMessage());
            }
            return "/events/admin/show-event/add-performer";
        }

        Performer editPerformer=performerRepository.getOne(selectedPerformer.getId());
        Event event=eventRepository.getOne(Integer.parseInt(id));
        event.getListOfPerformers().add(editPerformer);
        //editPerformer.getListOfEvents().add(event);
        performerRepository.save(editPerformer);

        return "redirect:/performers/show-performer?id=" + editPerformer.getId();
    }

    @RequestMapping("/show-event/{id}/{login}")
    public String addUserOnEvent(@PathVariable("id") String id,
                               @PathVariable("login") String login){
        User user = userRepository.findByUsername(login);
        Event event = eventRepository.findById(Integer.parseInt(id)).get();
        event.getListOfParticipants().add(user);
        //user.getListOfEvents().add(event);
        userRepository.save(user);

        return "redirect:/events";
    }

    @RequestMapping("/show-event")
    public String one(@RequestParam("id") String id, ModelMap model){
        model.addAttribute("events", eventRepository.findById(Integer.parseInt(id)).get());
        return "/events/show-event";
    }

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


    @DeleteMapping("/{id}/delete-event")
    public void deleteEvent(@PathVariable("id") String id){
        eventRepository.deleteById(Integer.parseInt(id));
    }
}
