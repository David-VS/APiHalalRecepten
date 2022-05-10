package be.ehb.apihalalrecepten.model;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReceptDao extends CrudRepository<Recept, Integer> {

    public List<Recept> findAllDistinctByNameAndScoreGreaterThan(String name, short score);

    /*
    @Query("select distinct r from Recept r ")
    public List<Recept> findSuperComplex();
    */

}
