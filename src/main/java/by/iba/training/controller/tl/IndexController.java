package by.iba.training.controller.tl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping("/")
    public String welcome(){
        return "index";
    }

    @RequestMapping("events/add-event")
    public String addNewFestival(){
        return "add-event";
    }
}
