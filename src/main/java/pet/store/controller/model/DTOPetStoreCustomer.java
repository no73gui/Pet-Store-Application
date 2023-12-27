package pet.store.controller.model;

import lombok.Data;
import lombok.NoArgsConstructor;


// 1c. i i i. separate DTO class for customer.
// lombok class-level annotations
@Data
@NoArgsConstructor
public class DTOPetStoreCustomer {
	// 1c. i i . same exact fields as Customer entity, JPA annotations removed for DTO.
	private Long customerId;
	private String customerFirstName;
	private String customerLastName;
	private String customerEmail;
		
	// exclude petStore Set field for sake of JPA recursion requirements.
	
	
}
