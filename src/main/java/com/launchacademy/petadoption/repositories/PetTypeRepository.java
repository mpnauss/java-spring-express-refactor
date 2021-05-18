package com.launchacademy.petadoption.repositories;

import com.launchacademy.petadoption.models.PetType;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Integer> {
  public List<PetType> findAll();
}
