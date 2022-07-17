package com.dicetech.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dicetech.api.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	@Query (value = "select * from Employees where EMP_ID = ?1", nativeQuery = true)
	Optional<Employee> findByNo(int no);
}