package pet.store.service.mapper;

import java.util.Set;

import pet.store.controller.model.PetStoreData.CustomerData;
import pet.store.entity.Customer;

public interface CustomerMapper {

	CustomerData customerToCustomerData(Customer cust);
	Customer customerDataToCustomer(CustomerData custD);
	Set<CustomerData> listCustomerToListCustomerData(Set<Customer> listCust);
	Set<Customer> listCustomerDataToListCustomer(Set<CustomerData> listCustD);

}
