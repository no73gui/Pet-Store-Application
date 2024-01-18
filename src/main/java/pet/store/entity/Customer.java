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
@Data
@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long customerId;

	@Column(name = "customer_first_name")
	private String customerFirstName;
	@Column(name = "customer_last_name")
	private String customerLastName;
	@Column(name = "customer_email")
	private String customerEmail;

	// map relationship to other entities.
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@ManyToMany(mappedBy = "customers", cascade = CascadeType.PERSIST)
	private Set<PetStore> petStores;

}
