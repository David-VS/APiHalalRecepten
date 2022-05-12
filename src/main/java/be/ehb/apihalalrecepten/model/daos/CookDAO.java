package be.ehb.apihalalrecepten.model.daos;

import be.ehb.apihalalrecepten.model.entities.Cook;
import org.springframework.data.repository.CrudRepository;

public interface CookDAO extends CrudRepository<Cook, Integer> {


}
