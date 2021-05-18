package com.launchacademy.petadoption.seeders;

import com.launchacademy.petadoption.models.Pet;
import com.launchacademy.petadoption.models.PetType;
import com.launchacademy.petadoption.repositories.PetRepository;
import com.launchacademy.petadoption.repositories.PetTypeRepository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class PetSeeder implements CommandLineRunner {
  private PetRepository petRepository;
  private PetTypeRepository petTypeRepository;

  @Autowired
  public PetSeeder(PetRepository petRepository, PetTypeRepository petTypeRepository) {
    this.petRepository = petRepository;
    this.petTypeRepository = petTypeRepository;
  }

  @Override
  public void run(String... args) throws Exception {
    List<PetType> petTypes = petTypeRepository.findAll();
    List<Pet> pets = (List<Pet>) petRepository.findAll();

    PetType cat = new PetType();
    PetType dog = new PetType();

    if (petTypes.size() == 0) {
      cat.setType("Cat");
      cat.setImgUrl(
          "https://cdn.britannica.com/22/206222-131-E921E1FB/Domestic-feline-tabby-cat.jpg");
      cat.setDescription("Adorable, furry tyrants");
      petTypeRepository.save(cat);

      dog.setType("Dog");
      dog.setImgUrl("https://hips.hearstapps.com/hmg-prod.s3.amazonaws.com/images/golden-retriever-royalty-free-image-506756303-1560962726.jpg?crop=0.672xw:1.00xh;0.166xw,0&resize=640:*");
      dog.setDescription("Your new slobbery best friend");
      petTypeRepository.save(dog);
    }

    if (pets.size() == 0 ) {
       PetType mogwai = new PetType();
       mogwai.setType("Mogwai");
       mogwai.setImgUrl(
           "https://www.thesun.co.uk/wp-content/uploads/2020/01/2015Gremlins_GettyImages-163067748261115-920x610-696x442-1.jpg");
       mogwai.setDescription("Don't feed after midnight.");
       petTypeRepository.save(mogwai);

       Pet pet1 = new Pet();
       pet1.setName("Ron Purrlman");
       pet1.setImgUrl(
           "https://static.wixstatic.com/media/035bec_f0e960d1567648d989fd490f79fd46d7~mv2.jpg/v1/fill/w_640,h_806,al_c,q_85,usm_0.66_1.00_0.01/035bec_f0e960d1567648d989fd490f79fd46d7~mv2.webp");
       pet1.setAge(5);
       pet1.setVaccinationStatus(true);
       pet1.setAdoptionStory(
           "Mr Purrlman wishes to retire from the limelight of Hollywood and settle down somewhere on the ocean with a nice family that will give him lots of chin scritches.");
       pet1.setAdoptionAvailable(true);
       pet1.setPetType(cat);
       petRepository.save(pet1);

       Pet pet2 = new Pet();
       pet2.setName("Daisy");
       pet2.setImgUrl(
           "https://myanimals.com/wp-content/uploads/2018/06/old-dogs-sleep-a-lot-461x307.jpg");
       pet2.setAge(9);
       pet2.setVaccinationStatus(true);
       pet2.setAdoptionStory(
           "Daisy just wants to live somewhere warm and be driven around so she can stick her head out of the window.");
       pet2.setAdoptionAvailable(true);
       pet2.setPetType(dog);
       petRepository.save(pet2);

       Pet pet3 = new Pet();
       pet3.setName("Gizmo");
       pet3.setImgUrl(
           "https://www.thesun.co.uk/wp-content/uploads/2020/01/2015Gremlins_GettyImages-163067748261115-920x610-696x442-1.jpg");
       pet3.setAge(1);
       pet3.setVaccinationStatus(false);
       pet3.setAdoptionStory(
           "Gizmo comes from a mysterious far away land and is looking for someone to cuddle and talk to him");
       pet3.setAdoptionAvailable(true);
       pet3.setPetType(mogwai);
       petRepository.save(pet3);
     }
  }
}
