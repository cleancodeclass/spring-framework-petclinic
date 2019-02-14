package org.springframework.samples.petclinic.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.service.PetService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyPetController {
	private final PetService petService;

    @Autowired
    public MyPetController(PetService petService) {
        this.petService = petService;
    }
    
    @RequestMapping(value = { "/petListRequest"})
    public String showPetList(Map<String, Object> model) {
        model.put("pets", this.petService.findPets());
        return "pets/petList";
    }
}
