package pet.store.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import pet.store.controller.model.PetStoreData.CustomerData;
import pet.store.dao.CustomerDao;
import pet.store.entity.Customer;
import pet.store.service.mapper.CustMapperImpl;

@Service
@Transactional
public class CustomerService {
	@Autowired
	private CustomerDao dao;
	@Autowired
	private CustMapperImpl mapper;

	public CustomerData find(Long customerId) {
		boolean exists = dao.existsById(customerId);
		if (exists) {
			return mapper.customerToCustomerData(dao.getReferenceById(customerId));

		} else {
			return null;
		}
	}

	public CustomerData create() {
		Customer c = new Customer();
		dao.save(c);
		return mapper.customerToCustomerData(c);
	}

	public CustomerData update(Long customerId, CustomerData updatedCustomer) {

		if (customerId != null) {
			Customer c = dao.getReferenceById(customerId);
			if (updatedCustomer != null) {

				if (updatedCustomer.getCustomerFirstName() != null) {
					c.setCustomerFirstName(updatedCustomer.getCustomerFirstName());
				}

				if (updatedCustomer.getCustomerLastName() != null) {
					c.setCustomerLastName(updatedCustomer.getCustomerLastName());
				}

				if (updatedCustomer != null) {
					c.setCustomerEmail(updatedCustomer.getCustomerEmail());

				}

			}
			dao.save(c);
			return mapper.customerToCustomerData(c);

		} else

		{
			throw new EntityNotFoundException("Customer with ID " + customerId + " does not exist.");
		}

	}

	public CustomerData delete(Long custId) {

		if (dao.existsById(custId)) {
			// Customer c = dao.getReferenceById(custId);
			// dao.delete(c);
			dao.deleteById(custId);

		} else {
			throw new EntityNotFoundException("Customer with ID " + custId + " does not exist.");
		}
		return null;
	}

}
