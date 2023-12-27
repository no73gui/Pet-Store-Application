package pet.store.controller.model;

import java.util.Set;

import lombok.Data;
import lombok.NoArgsConstructor;
import pet.store.entity.EmployeeDAO;

// 1d. i i i.  Lombok class-level annotations
@Data
@NoArgsConstructor
public class DTOPetStoreEmployee {
	// 1d. i i. copy exact fields from Employee.java entity, exclude JPA annotations.
	private Long employee_id;
	
	private String employeeFirstName;
		
	private String employeeLastName;
	
	private Long employeePhone;
	
	private String jobTitle;
	
	// ignore petStore Set for sake of JPA recursion requirements
	
	public DTOPetStoreEmployee(EmployeeDAO employee) {
		this.employee_id = employee_id;
		this.employeeFirstName = employeeFirstName;
		this.employeeLastName = employeeLastName;
		this.employeePhone = employeePhone;
		this.jobTitle = jobTitle;
		
	}
}
