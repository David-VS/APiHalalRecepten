package be.ehb.apihalalrecepten.controller;

import be.ehb.apihalalrecepten.model.daos.CookDAO;
import be.ehb.apihalalrecepten.model.entities.Cook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cooks")
public class CookController {

    private CookDAO cookDAO;

    @Autowired
    public CookController(CookDAO cookDAO) {
        this.cookDAO = cookDAO;
    }

    @GetMapping()
    public Iterable<Cook> getAllCooks(){
        return cookDAO.findAll();
    }
}
