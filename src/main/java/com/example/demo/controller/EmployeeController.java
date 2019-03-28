package com.example.demo.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.entity.EmployeeDTO;
import com.example.demo.entity.ResponseData;
import com.example.demo.repository.EmployeeRepository;

/**
 * Employee Controller is the main controller for handling all requests
 * concerning Employee entity class
 * 
 * @author Chandra Kanth
 *
 */
@RestController
public class EmployeeController {

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	ModelMapper modelMapper;

	static ResponseData responseData = new ResponseData();

	/**
	 * 
	 * @return the welcome message for the application home page
	 */
	@GetMapping("/")
	public String homePage() {
		return "Welcome to Management system";
	}

	/**
	 * 
	 * @return all the employees in the table
	 */
	@GetMapping("/employees/all")
	public List<EmployeeDTO> findAll() {
		List<EmployeeDTO> employeeDTOs = new ArrayList();
		for (Employee e : employeeRepository.findAll()) {
			employeeDTOs.add(convertToDTO(e));
		}
		return employeeDTOs;
	}

	/**
	 * 
	 * @param employeeDTO containing the id of an employee
	 * @return the employee data whose id matches given input
	 */
	@PostMapping("/employees/id")
	public EmployeeDTO id(@RequestBody EmployeeDTO employeeDTO) {
		Optional<Employee> employee = employeeRepository.findById(employeeDTO.getId());
		if (employee.isPresent()) {
			Employee e = employee.get();
			return convertToDTO(e);
		} else {
			throw new EntityNotFoundException("No data exists for given ID");
		}
	}

	/**
	 * 
	 * @param employeeDTO containing the employee data we need saved
	 * @return the employee data after save successful
	 */
	@PostMapping("/employees/save")
	public Employee save(@RequestBody EmployeeDTO employeeDTO) {
		employeeDTO.setId(0);
		Employee employee = convertToEntity(employeeDTO);
		return employeeRepository.save(employee);
	}

	/**
	 * 
	 * @param employeeDTO containing the updated employee data
	 * @return the employee data after update successful
	 */
	@PostMapping("/employees/update")
	public Employee update(@RequestBody EmployeeDTO employeeDTO) {
		Employee employee = convertToEntity(employeeDTO);
		return employeeRepository.save(employee);
	}

	/**
	 * 
	 * @param employeeDTO containing the employee data to be deleted
	 * @return status code and relevant message after delete successful
	 */
	@PostMapping("employees/delete")
	public ResponseData delete(@RequestBody EmployeeDTO employeeDTO) {
		Employee employee = convertToEntity(employeeDTO);
		employeeRepository.deleteById(employee.getId());

		responseData.setResponseCode("200");
		responseData.setResponseMsg("Deleted Successfully");
		responseData.setTime(LocalDateTime.now().toString());
		return responseData;
	}

	private Employee convertToEntity(EmployeeDTO employeeDTO) {
		return modelMapper.map(employeeDTO, Employee.class);
	}

	private EmployeeDTO convertToDTO(Employee e) {
		return modelMapper.map(e, EmployeeDTO.class);
	}

}
