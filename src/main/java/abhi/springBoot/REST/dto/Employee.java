package abhi.springBoot.REST.dto;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Document
public class Employee {
	
	@Id
	String id;
	private String empName;
	private String deptName;
	private int age;

}
