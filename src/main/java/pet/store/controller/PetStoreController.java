package pet.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import pet.store.controller.model.PetStoreData;
import pet.store.service.PetStoreService;

// 4a. i. add @RestController as class-level. this tells Spring that this is a REST controller. It expects and returns JSON in the request/response bodies.
// the default response status code is 200 (OK).
@RestController

// 4a. ii. add @RequestMapping as class-level. tells Spring to map HTTP requests to specific methods in this controller and the request URI must start with "/pet_store".
@RequestMapping("/pet_store")

// 4a. iii. add @Slf4j as class-level. tells lombok to create slf4j logger. It adds a logger as an instance variable named log.
// used log.info("Line in log")

//@Slf4j

public class PetStoreController {

	// 4b. autowire (inject PetStoreService as instance variable
	@Autowired
	private PetStoreService pSS;
	// 4c. create public method that maps an HTTP POST request to "/pet_store". Response should be 201 (created).
	// pass the contents of the request body as a parameter

	@PostMapping("/create/pet-store")
	@ResponseStatus(HttpStatus.CREATED)
	public PetStoreData save() {

		// log the HTTP request parameterized. in parameter, return the DTOPetStoreData object from the body.
		return pSS.save();

	}



	@GetMapping("/check/pet-store/{petStoreId}")
	@ResponseStatus(HttpStatus.OK)
	public PetStoreData find(@PathVariable @RequestBody Long petStoreId) {
		return pSS.find(petStoreId);
	}



	@PutMapping("/update/pet-store/{petStoreId}")
	@ResponseStatus(HttpStatus.OK)
	public PetStoreData update(@PathVariable Long petStoreId,
			String petStoreName, String petStorePhone) {
		return pSS.update(petStoreId, petStoreName, petStorePhone);
	}

	@DeleteMapping("/delete/pet-store/{petStoreId}")
	@ResponseStatus(HttpStatus.OK)
	public PetStoreData delete(@PathVariable Long petStoreId){
		return pSS.delete(petStoreId);
	}

}
