package com.example.demo.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	//Read the value from appication.properties file
	@Value("${welcome.message}")
	private String welcome;

	/**
	 * 
	 * @return the welcome message for the application home page
	 */
	@GetMapping("/")
	public String homePage() {
		return "Welcome to "+welcome;
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

	// Demo for paging using data jpa
	/**
	 * 
	 * @param id is a path variable denoting page number
	 * @return all employees corresponding to the page number
	 */
	@GetMapping("/employees/some/{page}")
	public List<EmployeeDTO> findSome(@PathVariable("page") int id) {
		List<EmployeeDTO> employeeDTOs = new ArrayList();
		Pageable pageable = PageRequest.of(id - 1, 5);
		for (Employee e : employeeRepository.findAll(pageable)) {
			employeeDTOs.add(convertToDTO(e));
		}
		if (!employeeDTOs.isEmpty()) {
			return employeeDTOs;
		}
		else {
			throw new IllegalArgumentException("No elements present for given page number");
		}
	}
	
	@GetMapping("/employees/sorted")
	public List<EmployeeDTO> findSorted() {
		List<EmployeeDTO> employeesDTOs = new ArrayList();
		for(Employee e : employeeRepository.findAll(Sort.by("address").ascending())) {
			employeesDTOs.add(convertToDTO(e));
		}
		return employeesDTOs;
	}
	
	@GetMapping("/employees/sortPage/{page}")
	public List<EmployeeDTO> findPagingWithSort(@PathVariable("page") int id) {
		List<EmployeeDTO> employeeDTOs = new ArrayList();
		Pageable pageable = PageRequest.of(id - 1, 5, Sort.by("address").ascending().and(Sort.by("team").descending()));
		for (Employee e : employeeRepository.findAll(pageable)) {
			employeeDTOs.add(convertToDTO(e));
		}
		if (!employeeDTOs.isEmpty()) {
			return employeeDTOs;
		}
		else {
			throw new IllegalArgumentException("No elements present for given page number");
		}
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
			throw new EntityNotFoundException("No data exists for ID : " + employeeDTO.getId());
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
		
		ResponseData responseData = new ResponseData();
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
