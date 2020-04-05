package abhi.springBoot.REST.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import abhi.springBoot.REST.dto.Employee;
import abhi.springBoot.REST.service.EmployeeServiceImpl;
import abhi.springBoot.REST.service.IEmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RestController
@EnableSwagger2
@Api(value="EmployeeControllerApi", produces= MediaType.APPLICATION_JSON_VALUE)
public class EmployeeController {

	@Autowired
	IEmployeeService empServiceRef;
//	EmployeeServiceImpl empServiceRef;
	
//	@RequestMapping("/welcome")
//	public String welcomeEmployee() {
//		return "Hello Employee";
//	}
	
	@RequestMapping(method=RequestMethod.GET,value="/employees")
	public List<Employee> getAllEmployees(){
		return empServiceRef.getAllEmployee();
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/employees/{empName}")
	@ApiOperation("Get Employee detail with specific name")
	@ApiResponses(value= { @ApiResponse(code=200, message="OK", response=Employee.class)})
	public Employee getEmployeeById(@PathVariable String empName) {
		return empServiceRef.getEmployeeByName(empName);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/employees")
	public void addEmployee(@RequestBody Employee employee) {
		empServiceRef.addEmployee(employee);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/employees/{empName}")
	public void updateEmployee(@RequestBody Employee employee, @PathVariable String empName) {
		empServiceRef.updateEmployee(employee,empName);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/employees/{empName}")
	public void deleteEmployee(@PathVariable String empName) {
		empServiceRef.deleteEmployee(empName);
	}
}
