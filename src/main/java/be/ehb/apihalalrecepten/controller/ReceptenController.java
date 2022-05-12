package be.ehb.apihalalrecepten.controller;

import be.ehb.apihalalrecepten.model.entities.Recept;
import be.ehb.apihalalrecepten.model.daos.ReceptDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/recepten")
public class ReceptenController {

    private ReceptDao receptDao;

    @Autowired
    public ReceptenController(ReceptDao receptDao) {
        this.receptDao = receptDao;
    }

    @GetMapping
    public Iterable<Recept> getAllRecepten(){
        return receptDao.findAll();
    }

    @PostMapping
    public void addRecept(@RequestParam("naam") String naam,
                          @RequestParam("score") short score){
        Recept toSave = new Recept();
        toSave.setName(naam);
        toSave.setScore(score);

        receptDao.save(toSave);
    }
}