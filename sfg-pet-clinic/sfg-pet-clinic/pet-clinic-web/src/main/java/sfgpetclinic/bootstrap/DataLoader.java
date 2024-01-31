package sfgpetclinic.bootstrap;

import model.Owner;
import model.Vet;
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

    public DataLoader() {
        this.ownerService = new OwnerServiceMap();
        this.vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setName("John");
        owner1.setSurname("Doe");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setName("giovanni");
        owner2.setSurname("pippo");

        ownerService.save(owner2);

        System.out.println("Loaded owners...");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setName("Sam");
        vet1.setSurname("Smith");
        vetService.save(vet1);


        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setName("anna");
        vet2.setSurname("rossi");
        vetService.save(vet2);
        System.out.println("Loaded vets...");

    }
}
