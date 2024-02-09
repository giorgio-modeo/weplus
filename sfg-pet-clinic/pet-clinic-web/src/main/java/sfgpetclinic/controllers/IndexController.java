package sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @GetMapping("/index.html")
    public String index() {
        System.out.println("IndexController.index");
        return "index.html";
    }
    @RequestMapping("/oups")
    public String oupsHandler() {
        return "notimplemented";
    }
}
