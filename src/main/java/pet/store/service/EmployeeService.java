package pet.store.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	public EmployeeData save(Employee emp) {
		boolean exists = dao.existsById(emp.getEmployee_id());
		if (exists) {
			dao.save(emp);
			return mapper.employeeToEmployeeData(emp);
		} else if (!exists) {
			Employee nEmp = new Employee();
			dao.save(nEmp);
			return mapper.employeeToEmployeeData(nEmp);
		}
		return mapper.employeeToEmployeeData(emp);

		// log the HTTP request parameterized. in parameter, return the DTOPetStoreData
		// object from the body.
	}

	public EmployeeData find(Long employeeId) {
		boolean exists = dao.existsById(employeeId);
		if(exists) {
			return mapper.employeeToEmployeeData(dao.getReferenceById(employeeId));
		}
		else {
			return null;
		}
	}

	public EmployeeData update(
			Long employeeId,
			String firstName,
			String lastName,
			Long phone,
			String jobTitle) {

		if (dao.existsById(employeeId)) {
			Employee emp = dao.getReferenceById(employeeId);
			emp.setEmployeeFirstName(firstName);
			emp.setEmployeeLastName(lastName);
			emp.setEmployeePhone(phone);
			emp.setJobTitle(jobTitle);
		}
		return mapper.employeeToEmployeeData(dao.getReferenceById(employeeId));
	}

	public EmployeeData delete(Long employeeId) {
		if (dao.existsById(employeeId)) {
			dao.deleteById(employeeId);
		}

		return mapper.employeeToEmployeeData(dao.getReferenceById(employeeId));
	}

}
