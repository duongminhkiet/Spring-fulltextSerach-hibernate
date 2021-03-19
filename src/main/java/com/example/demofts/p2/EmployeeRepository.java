package com.example.demofts.p2;

import org.springframework.data.repository.Repository;

import com.example.demofts.objects.Employee;

public interface EmployeeRepository extends Repository<Employee, Long>, EmployeeRepositoryExt {

	Employee save(final Employee tweet);

}