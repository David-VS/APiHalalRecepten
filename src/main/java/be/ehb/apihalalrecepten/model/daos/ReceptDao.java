package be.ehb.apihalalrecepten.model.daos;


import be.ehb.apihalalrecepten.model.entities.Recept;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReceptDao extends CrudRepository<Recept, Integer> {

    public List<Recept> findAllByName(String name);

    //*
    @Query("select distinct r from Recept r ")
    public List<Recept> findSuperComplex();
    //*/

}
