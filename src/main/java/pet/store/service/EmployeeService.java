package pet.store.service;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityNotFoundException;
import pet.store.controller.model.PetStoreData.EmployeeData;
import pet.store.dao.EmployeeDao;
import pet.store.entity.Employee;
import pet.store.service.mapper.EmpMapperImpl;
@Service
public class EmployeeService {

	@Autowired
	private EmployeeDao dao;

	@Autowired
	private EmpMapperImpl mapper;
	
	@Transactional(readOnly=false)
	public EmployeeData save(Employee emp) {
		if(dao.existsById(emp.getEmployee_id())) {
			Employee e = dao.getReferenceById(emp.getEmployee_id());
			dao.save(e);
			return mapper.employeeToEmployeeData(e);
		}
		else {
			Employee e = new Employee();
			dao.save(e);
			return mapper.employeeToEmployeeData(e);
		}
		// log the HTTP request parameterized. in parameter, return the DTOPetStoreData
		// object from the body.
	}

	@Transactional(readOnly=true)
	public EmployeeData find(Long employeeId, Long petStoreId) throws NoSuchElementException {
		boolean empexists = dao.existsById(employeeId);
		if(empexists) {
			return mapper.employeeToEmployeeData(dao.getReferenceById(employeeId));
		}
		else {
			throw new EntityNotFoundException();
		}
	}
	@Transactional(readOnly=false)
	public EmployeeData update(
			Long employeeId,
			String firstName,
			String lastName,
			Long phone,
			String jobTitle) throws EntityNotFoundException {

		if (dao.existsById(employeeId)) {
			Employee emp = dao.getReferenceById(employeeId);
			emp.setEmployeeFirstName(firstName);
			emp.setEmployeeLastName(lastName);
			emp.setEmployeePhone(phone);
			emp.setJobTitle(jobTitle);
			return mapper.employeeToEmployeeData(dao.getReferenceById(employeeId));
		} else {
			throw new EntityNotFoundException();
		}
	}
	@Transactional(readOnly=false)
	public EmployeeData delete(Long employeeId) throws EntityNotFoundException {
		if (dao.existsById(employeeId)) {
			Employee e = dao.getReferenceById(employeeId);
			dao.delete(e);
			dao.save(e);
			return mapper.employeeToEmployeeData(dao.getReferenceById(employeeId));
		}
		else {
			throw new EntityNotFoundException();
		}

	}
	

}
