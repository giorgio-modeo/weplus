package sfgpetclinic.services.map;

import sfgpetclinic.model.Vet;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import sfgpetclinic.services.VetService;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class VetServiceMap extends AbstractMapService<Vet,Long> implements VetService {
    private final SpecialityServiceMap specialityService;

    public VetServiceMap(SpecialityServiceMap specialityService) {
        this.specialityService = specialityService;
    }


    @Override
    public Vet save(Vet object) {
        if (!object.getSpecialities().isEmpty()) {
            object.getSpecialities().forEach(speciality -> {
                if (speciality.getId() == null) {
                    speciality.setId(specialityService.save(speciality).getId());
                }
            });
        }
        return super.save(object);
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }
    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

}
