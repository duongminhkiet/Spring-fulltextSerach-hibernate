package com.example.demofts.p2;

import java.util.List;

import com.example.demofts.objects.Employee;

public interface EmployeeRepositoryExt {

	List<Employee> search(final String keywords);
	List<Employee> getPostBasedOnWord(String word);
	List<Employee> getListyKey(String searchTerm);
}