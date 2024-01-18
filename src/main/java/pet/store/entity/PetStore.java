package pet.store.entity;

import java.util.HashSet;
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

@Entity
@Data
public class PetStore {
	// add jakarta and lombok class-level annotations
	// define the primary key using @Id and define the Generation strategy for
	// creating this entity.
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long petStoreId;

	@Column(name = "pet_store_name")
	private String petStoreName;
	@Column(name = "pet_store_address")
	private String petStoreAddress;
	@Column(name = "pet_store_city")
	private String petStoreCity;
	@Column(name = "pet_store_state")
	private String petStoreState;
	@Column(name = "pet_store_zip_code")
	private String petStoreZip;
	@Column(name = "pet_store_phone")
	private String petStorePhone;

	// implement jakarta persistence.
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "pet_store_customer", joinColumns = @JoinColumn(name = "pet_store_id"), inverseJoinColumns = @JoinColumn(name = "customer_id"))
	private Set<Customer> customers;

	public Set<Customer> getCustomers(PetStore ps){
		Set<Customer> cust = new HashSet<>();

		for(Customer c : ps.customers) {
			cust.add(c);
		}
		return cust;
	}

	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@OneToMany(mappedBy = "petStore", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Employee> employees;

	public Set<Employee> getEmployee(PetStore ps){
		Set<Employee> emp = new HashSet<>();
		for(Employee e : ps.employees) {
			emp.add(e);
		}
		return emp;

	}

}
