package sfgpetclinic.bootstrap;

import model.Owner;
import model.Vet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import services.OwnerService;
import services.VetService;
import services.map.OwnerServiceMap;
import services.map.VetServiceMap;


@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;

    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setName("John");
        owner1.setSurname("Doe");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setName("giovanni");
        owner2.setSurname("pippo");

        ownerService.save(owner2);

        System.out.println("Loaded owners...");

        Vet vet1 = new Vet();
        vet1.setName("Sam");
        vet1.setSurname("Smith");
        vetService.save(vet1);


        Vet vet2 = new Vet();
        vet2.setName("anna");
        vet2.setSurname("rossi");
        vetService.save(vet2);
        System.out.println("Loaded vets...");

        ownerService.findAll().forEach(owner -> System.out.println(owner.getName()));

    }
}