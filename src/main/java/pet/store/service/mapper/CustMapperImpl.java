package pet.store.service.mapper;

import java.util.Set;

import org.springframework.stereotype.Component;

import pet.store.controller.model.PetStoreData.CustomerData;
import pet.store.entity.Customer;

@Component
public class CustMapperImpl implements CustomerMapper{

	@Override
	public CustomerData customerToCustomerData(Customer cust) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer customerDataToCustomer(CustomerData custD) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<CustomerData> listCustomerToListCustomerData(Set<Customer> listCust) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Customer> listCustomerDataToListCustomer(Set<CustomerData> listCustD) {
		// TODO Auto-generated method stub
		return null;
	}

}
