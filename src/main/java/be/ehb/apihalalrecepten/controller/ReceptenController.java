package be.ehb.apihalalrecepten.controller;

import be.ehb.apihalalrecepten.model.daos.CookDAO;
import be.ehb.apihalalrecepten.model.entities.Cook;
import be.ehb.apihalalrecepten.model.entities.Recept;
import be.ehb.apihalalrecepten.model.daos.ReceptDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/recepten")
public class ReceptenController {

    private ReceptDao receptDao;
    private CookDAO cookDAO;

    @Autowired
    public ReceptenController(ReceptDao receptDao, CookDAO cookDAO) {
        this.receptDao = receptDao;
        this.cookDAO = cookDAO;
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

    @PostMapping("/addCook")
    public void addCookToRecipe(@RequestParam("cookID") int cookID,
                                @RequestParam("receptID") int receptID){

        if(cookDAO.existsById(cookID)){
            Cook myCook = cookDAO.findById(cookID).get();
            if(receptDao.existsById(receptID)){
                Recept myRecept = receptDao.findById(receptID).get();
                myRecept.setCook(myCook);
                receptDao.save(myRecept);
            }
        }
    }
}