package pet.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import pet.store.controller.model.DTOPetStoreData;
import pet.store.service.PetStoreService;

// 4a. i. add @RestController as class-level. this tells Spring that this is a REST controller. It expects and returns JSON in the request/response bodies. 
// the default response status code is 200 (OK). 
@RestController

// 4a. ii. add @RequestMapping as class-level. tells Spring to map HTTP requests to specific methods in this controller and the request URI must start with "/pet_store". 
@RequestMapping("/pet_store")

// 4a. iii. add @Slf4j as class-level. tells lombok to create slf4j logger. It adds a logger as an instance variable named log.
// used log.info("Line in log")
@Slf4j

public class PetStoreController {
	
	// 4b. autowire (inject PetStoreService as instance variable
	@Autowired
	private PetStoreService pSS;
	
	// 4c. create public method that maps an HTTP POST request to "/pet_store". Response should be 201 (created).
	// pass the contents of the request body as a parameter
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public DTOPetStoreData createUpdatePetStore(@RequestBody DTOPetStoreData petStoreData) {
		
		// log the HTTP request parameterized. in parameter, return the DTOPetStoreData object from the body.
		log.info("Recieved POST request for PetStore: {}", petStoreData);
		
		DTOPetStoreData savePetStoreData = pSS.savePetStore(petStoreData);
		
		return savePetStoreData;
		
	}
	
}
