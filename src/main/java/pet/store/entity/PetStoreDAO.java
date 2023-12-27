package pet.store.entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data		
@Entity
public  class PetStoreDAO  {
	// add jakarta and lombok class-level annotations
		// define the primary key using @Id and define the Generation strategy for creating this entity.
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long petStoreId;
		
		@Column(name = "petStoreName")
		private String petStoreName;
		@Column(name = "petStoreAddress")
		private String petStoreAddress;
		@Column(name = "petStoreCity")
		private String petStoreCity;
		@Column(name = "petStroeState")
		private String petStoreState;
		@Column(name = "petStoreZipCode")
		private String petStoreZip;
		@Column(name = "petStorePhone")
		private String petStorePhone;
		
		// implement jakarta persistence.
		@EqualsAndHashCode.Exclude
		@ToString.Exclude
		@ManyToMany(cascade = CascadeType.PERSIST)
		@JoinTable(name = "pet_store_customer", joinColumns = @JoinColumn(name = "pet_store_id"), inverseJoinColumns = @JoinColumn(name = "customer_id"))
		private Set<CustomerDAO> customers;
		
		
		@EqualsAndHashCode.Exclude
		@ToString.Exclude
		@OneToMany(mappedBy = "petStore" , cascade = CascadeType.ALL, orphanRemoval = true )
		private Set<EmployeeDAO> employees;
		
		
	

}
