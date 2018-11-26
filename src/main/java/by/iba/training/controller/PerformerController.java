package by.iba.training.controller;

import by.iba.training.entity.Performer;
import by.iba.training.repository.EventRepository;
import by.iba.training.repository.PerformerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/performers")
public class PerformerController {

    @Autowired
    PerformerRepository performerRepository;

    @Autowired
    EventRepository eventRepository;

    @RequestMapping(method = RequestMethod.GET)
    public String all(ModelMap model){
        model.addAttribute("performers", performerRepository.findAll());
        return "/performers";
    }

    @GetMapping("/show-performer")
    public String one(@RequestParam("id") String id, ModelMap model){
        model.addAttribute("performers", performerRepository.findById(Integer.parseInt(id)).get());
        return "/performers/show-performer";
    }

    @RequestMapping(value = "/admin/add-performer", method = RequestMethod.GET)
    public String createEvent(Model model) {
        model.addAttribute("performerForm", new Performer());

        return "performers/admin/add-performer";
    }

    @RequestMapping(value = "/admin/add-performer", method = RequestMethod.POST)
    public String createEvent(@ModelAttribute("performerForm") Performer performerForm,
                              BindingResult bindingResult,
                              Model model) {
        //userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "performers/admin/add-performer";
        }

        performerRepository.save(performerForm);

        return "redirect:/performers";
    }


    @DeleteMapping("/delete")
    public String delete(@RequestParam("id") Integer id){
        performerRepository.deleteById(id);
        return "redirect:/performers";
    }
}
