package pet.store.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

//add jakarta and lombok class-level annotations
@Entity
@Data
@ToString(exclude = "petStore")
@EqualsAndHashCode(exclude = "petStore")
public class Employee {
	
	// define the primary key using @Id
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long employee_id;
	
	@Column(name = "employeeFirstName")
	private String employeeFirstName;
		
	@Column(name = "employeeLastName")
	private String employeeLastName;
	
	@Column(name = "employeePhone")
	private Long employeePhone;
	
	@Column(name = "employeeTitle")
	private String jobTitle;
	
	// many employees can work at one pet store. Use @ManyToOne to define entity relationship. Use @JoinColumn(name = ...) to define the column of commonality to join data.
	// define entity relationship. cascadetype.all for cascade on delete.
	// the joincolumn will join the id data from petStore
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "petStoreId")
	private PetStore petStore;
	
	
	

}
