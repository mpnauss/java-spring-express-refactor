package com.launchacademy.petadoption.repositories;

import com.launchacademy.petadoption.models.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Integer> {

}
