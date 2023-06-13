package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import guru.springframework.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader  implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {
        PetType petType1 = new PetType();
        petType1.setName("Pies");
        PetType savedPetType1 = petTypeService.save(petType1);

        PetType petType2 = new PetType();
        petType1.setName("Kot");
        PetType savedPetType2 = petTypeService.save(petType2);
        System.out.println("Loaded Pet Types....");

        Owner owner1 = new Owner();
        owner1.setFirstName("Adrian");
        owner1.setLastName("Wiechec");
        owner1.setCity("Zamarski");
        owner1.setAddress("Cieszynska 154");
        owner1.setTelephone("0700");


        Pet  piesAdriana = new Pet();
        piesAdriana.setPetType(savedPetType1);
        piesAdriana.setOwner(owner1);
        piesAdriana.setName("Sara");
        piesAdriana.setBirthDate(LocalDate.now());
        owner1.getPets().add(piesAdriana);
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenanne");
        owner2.setCity("Zamarski");
        owner2.setAddress("Glowna 12");
        owner2.setTelephone("777");

        Pet kotFiony = new Pet();
        kotFiony.setName("Gacek");
        kotFiony.setOwner(owner2);
        kotFiony.setBirthDate(LocalDate.now());
        kotFiony.setPetType(petType2);
        owner2.getPets().add(kotFiony);

        ownerService.save(owner2);


        System.out.println("Loaded Owners....");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        vetService.save(vet1);


        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");

        vetService.save(vet2);

        System.out.println("Loaded Vets....");

    }
}
