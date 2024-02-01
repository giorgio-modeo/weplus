package pets;

public class PetServiceFactory {

public PetService getPetService(String petType){
//    prova
        switch (petType){
            case "cat":
                return new CatPetService();
            case "dog":
                return new DogPetService();
            default:
                return new DogPetService();
        }
    }

}
