package org.springframework.samples.petclinic.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.model.Pet;
import org.springframework.samples.petclinic.repository.PetRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PetServiceImpl implements PetService {
	
	@Autowired
	private PetRepository petRepository;
	
//	@Autowired
//    public PetServiceImpl(PetRepository petRepository) {
//        this.petRepository = petRepository;
//    }
	
	@Override
	@Transactional(readOnly = true)
	public Collection<Pet> findPets() {
		return petRepository.findAll();
	}

}
