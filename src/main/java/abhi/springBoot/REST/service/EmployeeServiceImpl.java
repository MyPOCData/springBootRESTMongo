package abhi.springBoot.REST.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import abhi.springBoot.REST.dao.IEmployeeDAO;
import abhi.springBoot.REST.dto.Employee;

@Service
public class EmployeeServiceImpl implements IEmployeeService{

//	List<Employee> empList = new ArrayList<>(Arrays.asList(
//			new Employee(1,"Abhi","ATV"),
//			new Employee(2, "Amit", "IT")));
	
	@Autowired
	public IEmployeeDAO daoRef;

	@Override
	public List<Employee> getAllEmployee() {
		//return empList;
		return daoRef.findAll();
	}

	@Override
	public Employee getEmployeeByName(String empName) {
		//return empList.stream().filter(e -> e.getEmpId() == empID).findFirst().get();
		return daoRef.findByempName(empName);
	}

	@Override
	public void addEmployee(Employee employee) {
		//empList.add(employee);
		daoRef.save(employee);
	}

	@Override
	public void updateEmployee(Employee employee, String empName) {
//		for(int i=0; i<empList.size(); i++) {
//			Employee e = empList.get(i);
//			if(e.getEmpId()==empId) {
//				empList.set(i, employee);
//				return;
//			}
//		}		
		Employee e = daoRef.findByempName(empName);
		e.setDeptName(employee.getDeptName());
		e.setAge(employee.getAge());
		daoRef.save(e);
	}

	@Override
	public void deleteEmployee(String empName) {
//		empList.removeIf(e -> e.getEmpId() == empId);
		Employee e = daoRef.findByempName(empName);
		daoRef.delete(e);
	}
}
