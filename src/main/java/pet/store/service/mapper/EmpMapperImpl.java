package pet.store.service.mapper;

import java.util.Set;

import org.springframework.stereotype.Component;

import pet.store.controller.model.PetStoreData.EmployeeData;
import pet.store.entity.Employee;
@Component
public class EmpMapperImpl implements EmployeeMapper {

	@Override
	public EmployeeData employeeToEmployeeData(Employee emp) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee employeeToEmployeeData(EmployeeData empD) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Employee> listEmployeeDataToListEmployee(Set<EmployeeData> setEmpD) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<EmployeeData> listEmployeeToListEmployeeData(Set<Employee> setEmp) {
		// TODO Auto-generated method stub
		return null;
	}

}
