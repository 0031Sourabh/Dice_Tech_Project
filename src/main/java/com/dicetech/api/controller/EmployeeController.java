package com.dicetech.api.controller;

import com.dicetech.Employee.exception.ResourceNotFoundException;
import com.dicetech.api.entity.AuthRequest;
import com.dicetech.api.entity.Employee;
import com.dicetech.api.entity.User;
import com.dicetech.api.repository.EmployeeRepository;
import com.dicetech.api.repository.UserRepository;
import com.dicetech.api.util.JwtUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private JwtUtil jwtUtil;
    
    @Autowired
    private AuthenticationManager authenticationManager;
    
    @Autowired
    private UserRepository repository;
    
    @Autowired
	private EmployeeRepository emprepository;

    

    @PostMapping("/authenticate")
    public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword())
            );
        } catch (Exception ex) {
            throw new Exception("inavalid username/password");
        }
        return jwtUtil.generateToken(authRequest.getUserName());
    }
    
    
    //URL - localhost:9090/api/getAllEmployees
    @GetMapping("/api/getAllEmployees")
    public List<Employee> getAllEmployees() {
		return emprepository.findAll();
	}
    
    //URL - localhost:9090/api/getAllEmployees/1001
    @GetMapping("/api/getAllEmployees/{empId}")
	public ResponseEntity<Employee> getEmployeeByNo(@PathVariable int empId) {
		Employee employee = emprepository.findByNo(empId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with the id"+empId));
		return ResponseEntity.ok(employee);
	}
	
	//URL - localhost:9090/api/createEmployees
	@PostMapping("/api/createEmployees")
	public Employee createEmployee(@RequestBody Employee employee) {
	 return emprepository.save(employee);
	}
	
	//URL - localhost:9090/api/getAllEmployees/1001
	@PutMapping("/api/getAllEmployees/{empId}")
	public void updateEmployee(@PathVariable int empId, @RequestBody Employee employeeDetails) {
		emprepository.save(employeeDetails);
	}
	
	//URL - localhost:9090/api/getAllEmployees/1001
	@DeleteMapping("/api/getAllEmployees/{empId}")
	public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable int empId) {
		Employee employee = emprepository.findByNo(empId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee does not exist with id:" + empId));
				
		emprepository.delete(employee);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
    
    
}
