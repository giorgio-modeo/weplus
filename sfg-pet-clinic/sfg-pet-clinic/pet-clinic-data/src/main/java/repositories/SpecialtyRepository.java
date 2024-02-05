package repositories;

import model.Speciality;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialtyRepository extends CrudRepository<Speciality, Long> {
}
