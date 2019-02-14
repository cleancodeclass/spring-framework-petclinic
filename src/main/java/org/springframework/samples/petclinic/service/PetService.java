package org.springframework.samples.petclinic.service;

import java.util.Collection;

import org.springframework.samples.petclinic.model.Pet;

public interface PetService {

	Collection<Pet> findPets();

}
