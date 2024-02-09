package sfgpetclinic.services;


import sfgpetclinic.model.Speciality;

public interface SpecialtyService extends CrudService<Speciality, Long> {
    Speciality save(Speciality radiology);
}
