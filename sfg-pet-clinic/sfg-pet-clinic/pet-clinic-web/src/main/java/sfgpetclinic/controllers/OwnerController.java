package sfgpetclinic.controllers;

import model.Owner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import services.OwnerService;
import services.map.OwnerServiceMap;

import java.util.List;
import java.util.Set;

@RequestMapping("/owners")
@Controller
public class OwnerController {
    private final OwnerService ownerService;
    public OwnerController() {
        this.ownerService = new OwnerServiceMap();
    }
    @RequestMapping({"","/", "/index", "/index.html"})
    public String listOwners(Model model) {
        model.addAttribute("owners", ownerService.findAll());
        ownerService.findAll().forEach(owner -> System.out.println(owner.getName()));
        return "owners/index";
    }
}
