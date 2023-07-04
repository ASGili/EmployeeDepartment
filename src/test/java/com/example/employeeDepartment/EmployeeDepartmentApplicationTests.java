package com.example.employeeDepartment;

import com.example.employeeDepartment.models.Assignment;
import com.example.employeeDepartment.models.Department;
import com.example.employeeDepartment.models.Employee;
import com.example.employeeDepartment.models.Project;
import com.example.employeeDepartment.repositories.AssignmentRepository;
import com.example.employeeDepartment.repositories.DepartmentRepository;
import com.example.employeeDepartment.repositories.EmployeeRepository;
import com.example.employeeDepartment.repositories.ProjectRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class EmployeeDepartmentApplicationTests {

	@Autowired
	EmployeeRepository employeeRepository;
	@Autowired
	DepartmentRepository departmentRepository;
	@Autowired
	AssignmentRepository assignmentRepository;
	@Autowired
	ProjectRepository projectRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void canAddEmployee(){
		Department HR = new Department("HR");
		departmentRepository.save(HR);
		Employee employee1 = new Employee("John","Johnson","1234", HR);
		employeeRepository.save(employee1);
	}
	@Test
	public void canAddAssignment() {
		Department HR = new Department("HR");
		departmentRepository.save(HR);
		Employee employee2 = new Employee("Harry", "Harrison", "4321", HR);
		employeeRepository.save(employee2);
		Project project1 = new Project("Hiring", 10);
		projectRepository.save(project1);
		Assignment assignment1 = new Assignment(employee2, project1);
		assignmentRepository.save(assignment1);
	}

}
