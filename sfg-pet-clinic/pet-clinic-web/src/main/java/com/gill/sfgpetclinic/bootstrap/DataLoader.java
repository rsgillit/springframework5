package com.gill.sfgpetclinic.bootstrap;

import com.gill.sfgpetclinic.model.Owner;
import com.gill.sfgpetclinic.model.Pet;
import com.gill.sfgpetclinic.model.PetType;
import com.gill.sfgpetclinic.model.Vet;
import com.gill.sfgpetclinic.services.OwnerService;
import com.gill.sfgpetclinic.services.PetService;
import com.gill.sfgpetclinic.services.PetTypeService;
import com.gill.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final PetService petService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, PetService petService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.petService = petService;
        System.out.println("I am initialized");
    }

    @Override
    public void run(String... args) throws Exception {
        initOnStartup();
    }

    private void initOnStartup() {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.setAddress("123 Brick st");
        owner1.setCity("Miami");
        owner1.setTelephone("123123123");

        Pet mikesPet = new Pet();
        mikesPet.setPetType(savedDogPetType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("Rosco");
        owner1.getPets().add(mikesPet);
        ownerService.save(owner1);


        owner1.getPets().forEach(pet -> {
            System.out.println(pet.getPetType().getId());
            System.out.println(pet.getId());
        });

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenanne");
        owner2.setAddress("123 Brick st");
        owner2.setCity("Miami");
        owner2.setTelephone("345345345");

        Pet fionasCat = new Pet();
        fionasCat.setPetType(savedCatPetType);
        fionasCat.setOwner(owner2);
        fionasCat.setBirthDate(LocalDate.now());
        fionasCat.setName("Just Cat");
        owner2.getPets().add(fionasCat);
        ownerService.save(owner2);

        owner2.getPets().forEach(pet -> {
            System.out.println(pet.getPetType().getId());
            System.out.println(pet.getId());
        });

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");

        vetService.save(vet2);

        System.out.println("Loaded Owners and Vets...");


    }

}
