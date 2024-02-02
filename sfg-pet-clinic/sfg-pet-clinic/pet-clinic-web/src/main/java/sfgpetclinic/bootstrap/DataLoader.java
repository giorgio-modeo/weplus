package sfgpetclinic.bootstrap;

import model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import services.OwnerService;
import services.PetTypeService;
import services.SpecialityService;
import services.VetService;

import java.time.LocalDate;


@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petType;
    private final SpecialityService specialityService;

    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petType, SpecialityService specialityService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petType = petType;
        this.specialityService = specialityService;
    }


    @Override
    public void run(String... args) throws Exception {
        int count = petType.findAll().size();
        if (count == 0) {
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petType.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petType.save(cat);

        Speciality radiology = new Speciality();
        Speciality surgery = new Speciality();
        Speciality dentistry = new Speciality();

        radiology.setDescription("Radiology");
        surgery.setDescription("Surgery");
        dentistry.setDescription("Dentistry");


        Speciality savedRadiology = specialityService.save(radiology);
        Speciality savedSurgery = specialityService.save(surgery);
        Speciality savedDentistry = specialityService.save(dentistry);


        Owner owner1 = new Owner();
        Pet johnsPet = new Pet();

        owner1.setName("John");
        owner1.setSurname("Doe");
        owner1.setAddress("123 Brickerel");
        owner1.setCity("Miami");
        owner1.setTelephone("1231231234");

        johnsPet.setPetType(savedDogPetType);
        johnsPet.setOwner(owner1);
        johnsPet.setBirthDate(LocalDate.now());
        johnsPet.setName("Rosco");


        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setName("giovanni");
        owner2.setSurname("pippo");
        owner2.setAddress("13 Grickerel");
        owner2.setCity("Rome");
        owner2.setTelephone("1231231234");

        Pet giovannisPet = new Pet();
        giovannisPet.setPetType(savedCatPetType);
        giovannisPet.setOwner(owner2);
        giovannisPet.setBirthDate(LocalDate.now());
        giovannisPet.setName("Micio");


        ownerService.save(owner2);

        System.out.println("Loaded owners...");

        Vet vet1 = new Vet();
        vet1.setName("Sam");
        vet1.setSurname("Smith");
        vet1.getSpecialities().add(savedRadiology);

        vetService.save(vet1);


        Vet vet2 = new Vet();
        vet2.setName("anna");
        vet2.setSurname("rossi");
        vetService.save(vet2);
        vet2.getSpecialities().add(savedSurgery);
        System.out.println("Loaded vets...");
    }
}
