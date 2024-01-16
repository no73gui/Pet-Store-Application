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

import pet.store.controller.model.PetStoreData.EmployeeData;
import pet.store.entity.Employee;
import pet.store.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService eS;
	// 4c. create public method that maps an HTTP POST request to "/pet_store".
	// Response should be 201 (created).
	// pass the contents of the request body as a parameter

	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	public EmployeeData save(@RequestBody Employee emp) {

		// log the HTTP request parameterized. in parameter, return the DTOPetStoreData
		// object from the body.
		// log.info("Received POST request for PetStore: {}", ps.getPetStoreId());
		return eS.save(emp);

	}

	@GetMapping("/check/{petStoreId}")
	@ResponseStatus(HttpStatus.OK)
	public EmployeeData find(@PathVariable @RequestBody Long petStoreId) {
		return eS.find(petStoreId);
	}

	@PutMapping("/update/{petStoreId}")
	@ResponseStatus(HttpStatus.OK)
	public EmployeeData update(@PathVariable @RequestBody Long employeeId, String empFirstName, String empLastName,
			Long empPhone, String jobTitle) {
		return eS.update(employeeId, empFirstName, empLastName, empPhone, jobTitle);
	}

	@DeleteMapping("/delete/{petStoreId}")
	@ResponseStatus(HttpStatus.OK)
	public EmployeeData delete(@PathVariable @RequestBody Long empId) {
		return eS.delete(empId);
	}

}
