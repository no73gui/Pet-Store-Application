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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import pet.store.controller.model.PetStoreData.CustomerData;
import pet.store.service.CustomerService;

@RestController
@RequestMapping("/pet_store")
public class CustomerController {
	@Autowired
	private CustomerService cS;
	// 4c. create public method that maps an HTTP POST request to "/pet_store".
	// Response should be 201 (created).
	// pass the contents of the request body as a parameter

	@PostMapping("/create/customer")
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	// http://localhost:8080/pet_store/create/customer?id
	public CustomerData create() {

		// log the HTTP request parameterized. in parameter, return the DTOPetStoreData
		// object from the body.
		// log.info("Recieved POST request for PetStore: {}", ps.getPetStoreId());
		return cS.create();

	}

	@GetMapping("/check/customer/{customerId}")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public CustomerData find(@PathVariable @RequestBody Long customerId) {
		return cS.find(customerId);
	}

	@PutMapping("/update/customer/{customerId}")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	// http://localhost:8080/pet_store/update/customer/
	public CustomerData update(@PathVariable Long customerId, @RequestBody CustomerData updatedCustomer) {
		return cS.update(customerId, updatedCustomer);
	}

	@DeleteMapping("/delete/customer/{customerId}")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public CustomerData delete(@PathVariable Long custId) {
		return cS.delete(custId);
	}
}
