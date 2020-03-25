package abhi.springBoot.REST.service;

import java.util.List;

import org.springframework.stereotype.Service;

import abhi.springBoot.REST.dto.Employee;

@Service
public interface IEmployeeService {

	List<Employee> getAllEmployee();
	Employee getEmployeeByName(String empName);
	void addEmployee(Employee employee);
	void updateEmployee(Employee employee, String empName);
	void deleteEmployee(String empName);

}
