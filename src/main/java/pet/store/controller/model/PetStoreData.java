package pet.store.controller.model;

import java.util.Set;

import lombok.Data;
import lombok.NoArgsConstructor;
import pet.store.entity.Customer;
import pet.store.entity.Employee;
import pet.store.entity.PetStore;

// 1b.  Lombok class-level annotations
// inner-class needs to be static to avoid the class can be used as separate DTO
@Data
@NoArgsConstructor
public class PetStoreData {
	//1d. i i i.  Lombok class-level annotations
	@NoArgsConstructor
	@Data
	public static class EmployeeData {
		// 1d. i i. copy exact fields from Employee.java entity, exclude JPA annotations.
			private Long employee_id;

			private String employeeFirstName;

			private String employeeLastName;

			private Long employeePhone;

			private String jobTitle;

			// ignore petStore Set for sake of JPA recursion requirements



	}

	@NoArgsConstructor
	@Data
	public static class CustomerData {

		// 1c. i i i. separate DTO class for customer.
		// lombok class-level annotations
		// 1c. i i . same exact fields as Customer entity, JPA annotations removed for
		// DTO.
		private Long customerId;
		private String customerFirstName;
		private String customerLastName;
		private String customerEmail;

		// exclude petStore Set field for sake of JPA recursion requirements.
	}

	// 1b. same fields as PetStore.java
	private Long petStoreId;
	private String petStoreName;
	private String petStoreAddress;
	private String petStoreCity;
	private String petStoreState;
	private String petStoreZip;
	private String petStorePhone;
	// 1e. Change data type of customers from Set<Customer> to DTOPetStoreCustomer.
	private Set<Customer> customers;
	// 1e. Change data type of employees from Set<Employee> to DTOPetStoreEmployee
	private Set<Employee> employees;

	// 1f. Add constructor that takes in a PetStore object as a parameter.
	// set all matching fields in the PetStoreData class to the data in PetStores
	// class.

	// also set the employees and customers fields to the respective DTO. These DTOs
	// are Sets, so loops need to be used.

	public PetStoreData(PetStore petStore) {

		this.petStoreId = petStore.getPetStoreId();
		this.petStoreName = petStore.getPetStoreName();
		this.petStoreAddress = petStore.getPetStoreAddress();
		this.petStoreCity = petStore.getPetStoreCity();
		this.petStoreState = petStore.getPetStoreState();
		this.petStoreZip = petStore.getPetStoreZip();
		this.petStorePhone = petStore.getPetStorePhone();
		this.customers = petStore.getCustomers(petStore);
		this.employees = petStore.getEmployee(petStore);
	}

}

	// the PetStore entity returns a set of data for employee and customer. Because
	// there is multiple values being returned in a set,
	// a for loop needs to be used to add all of the data to this object, because
	// this DTO is what the API will respond with.

//	public DTOPetStoreData(PetStoreDAO ps) {
//		this.petStoreId = ps.getPetStoreId();
//		this.petStoreName = ps.getPetStoreName();
//		this.petStoreAddress = ps.getPetStoreAddress();
//		this.petStoreCity= ps.getPetStoreCity();
//		this.petStoreState= ps.getPetStoreState();
//		this.petStoreZip= ps.getPetStoreZip();
//		this.petStorePhone= ps.getPetStorePhone();
//		//return a set of customers from CustomerDAO.
//		this.customers = ps.populateEmp(ps);
	// use a for loop to return the Set of employees FROM the Employee entity --
	// EmployeeDAO ---. for each object returned from
	// the entity, the for loop will iterate through the Set of data from the
	// employee entity.
//		for(EmployeeDAO employee : ps.getEmployees()) {



