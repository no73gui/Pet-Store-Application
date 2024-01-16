package pet.store.service.mapper;

import java.util.Set;

import pet.store.controller.model.PetStoreData.EmployeeData;
import pet.store.entity.Employee;
public interface EmployeeMapper {
	EmployeeData employeeToEmployeeData(Employee emp);
	Employee employeeToEmployeeData(EmployeeData empD);
	Set<Employee> listEmployeeDataToListEmployee(Set<EmployeeData> setEmpD);
	Set<EmployeeData> listEmployeeToListEmployeeData(Set<Employee> setEmp);

}
