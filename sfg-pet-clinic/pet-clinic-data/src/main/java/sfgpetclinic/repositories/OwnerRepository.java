package sfgpetclinic.repositories;


import sfgpetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface OwnerRepository extends CrudRepository<Owner, Long> {

    Owner findBySurname(String lastName);

    List<Owner> findAllBySurnameLike(String lastName);

}
