package com.example.demofts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demofts.objects.Employee;
import com.example.demofts.p2.EmployeeRepository;

@Component
public class DatabaseLoader implements CommandLineRunner {

	private final EmployeeRepository repository;

	@Autowired
	public DatabaseLoader(EmployeeRepository repository) {
		this.repository = repository;
	}

	@Override
	public void run(String... strings) throws Exception {
		Employee employee = new Employee();
		employee.setFirstName("chữ Nguyen thì không ra kết quả Nguyễn Bạn đang đi đâu đó");
		employee.setLastName("Việt Nam chữ Nguyen thì không ra kết quả Nguyễn Bạn đang đi đâu đó");
		this.repository.save(employee);
	}
}