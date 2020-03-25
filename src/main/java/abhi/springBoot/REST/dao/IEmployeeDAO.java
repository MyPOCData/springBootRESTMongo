package abhi.springBoot.REST.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import abhi.springBoot.REST.dto.Employee;

@Service
@Repository
public interface IEmployeeDAO extends MongoRepository<Employee, String>{

	public Employee findByempName(String empName);

}
