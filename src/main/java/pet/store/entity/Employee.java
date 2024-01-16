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
@Data
@ToString(exclude = "petStore")
@EqualsAndHashCode(exclude = "petStore")
@Entity
public class Employee {

	// define the primary key using @Id

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long employee_id;

	@Column(name = "employee_first_name")
	private String employeeFirstName;

	@Column(name = "employee_last_name")
	private String employeeLastName;

	@Column(name = "employee_phone")
	private Long employeePhone;

	@Column(name = "employee_title")
	private String jobTitle;

	// many employees can work at one pet store. Use @ManyToOne to define entity relationship. Use @JoinColumn(name = ...) to define the column of commonality to join data.
	// define entity relationship. cascadetype.all for cascade on delete.
	// the joincolumn will join the id data from petStore
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "petStore")
	private PetStore petStore;




}
