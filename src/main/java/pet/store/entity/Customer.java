package pet.store.entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

//add jakarta and lombok class-level annotations
@Entity
@Data
@EqualsAndHashCode(exclude = "petStores")
@ToString(exclude = "petStores")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long customerId;
	
	@Column(name = "customerFirstName")
	private String customerFirstName;
	@Column(name = "customerLastName")
	private String customerLastName;
	@Column(name = "customerEmail")
	private String customerEmail;
	
	// map relationship to other entities.
	@ManyToMany(mappedBy = "customers", cascade = CascadeType.PERSIST)
	private Set<PetStore> petStores;

}
