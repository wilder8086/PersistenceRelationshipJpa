package ar.edu.frba.utn.tacs.unidirectionalbidirectional.service;

import ar.edu.frba.utn.tacs.unidirectionalbidirectional.dao.EmployeeRepository;
import ar.edu.frba.utn.tacs.unidirectionalbidirectional.entity.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmployeeService {
	
    @Autowired
    EmployeeRepository employeeRepository;


    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);

    }


	public List<Employee> getEmployees() {
		// TODO Auto-generated method stub
		return employeeRepository.findAll();
	}

}
