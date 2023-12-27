package pet.store.controller.model;

import java.util.HashSet;
import java.util.Set;

import lombok.NoArgsConstructor;
import pet.store.entity.EmployeeDAO;
import pet.store.entity.PetStoreDAO;

// 1b.  Lombok class-level annotations
@NoArgsConstructor
public class DTOPetStoreData {
	// 1b. same fields as PetStore.java
	private Long petStoreId;
	private String petStoreName;
	private String petStoreAddress;
	private String petStoreCity;
	private String petStoreState;
	private String petStoreZip;
	private String petStorePhone;
	// 1e. Change data type of customers from Set<Customer> to DTOPetStoreCustomer.
	private Set<DTOPetStoreCustomer> customers;
	// 1e. Change data type of employees from Set<Employee> to DTOPetStoreEmployee
	private Set<DTOPetStoreEmployee> employees;
	
	// 1f. Add constructor that takes in a PetStore object as a parameter. 
	// set all matching fields in the PetStoreData class to the data in PetStores class.
	
	// also set the employees and customers fields to the respective DTO. These DTOs are Sets, so loops need to be used. 
	 
	// the PetStore entity returns a set of data for employee and customer. Because there is multiple values being returned in a set,
	// a for loop needs to be used to add all of the data to this object, because this DTO is what the API will respond with.
	public DTOPetStoreData(PetStoreDAO ps) {
		this.petStoreId = ps.getPetStoreId();
		this.petStoreName = ps.getPetStoreName();
		this.petStoreAddress = ps.getPetStoreAddress();
		this.petStoreCity= ps.getPetStoreCity();
		this.petStoreState= ps.getPetStoreState();
		this.petStoreZip= ps.getPetStoreZip();
		this.petStorePhone= ps.getPetStorePhone();
		//return a set of customers from CustomerDAO.
		this.customers = ps.populateEmp(ps);
		// use a for loop to return the Set of employees FROM the Employee entity -- EmployeeDAO ---. for each object returned from
		// the entity, the for loop will iterate through the Set of data from the employee entity.
		for(EmployeeDAO employee : ps.getEmployees()) {
	
	
	public void populateEmp(Set<EmployeeDAO> employeeDAOs) {
		employees = new HashSet<>();
		
		// iterate through employee set
		// expect Employee entity object, map to parameterized Set
		for(EmployeeDAO employeeDAO : employeeDAOs) {
			// assign the entity object to an employee DTO for each iteration
			DTOPetStoreEmployee dtoEmp = new DTOPetStoreEmployee(employeeDAO);
			employees.add(dtoEmp);
		}
		
		
		
	}
	
	
	
}
