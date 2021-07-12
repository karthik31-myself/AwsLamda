package com.example.LamWithDynamoDb;

import com.example.LamWithDynamoDb.entity.Employee;
import com.example.LamWithDynamoDb.repository.EmpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@SpringBootApplication
public class LamWithDynamoDbApplication  {
	@Autowired
	private EmpRepo empRepo;
	@Bean
	public Supplier<List<Employee>> displayAllData(){
		return()-> empRepo.showAll();
	}

	@Bean
	public Function<String,List<Employee>> findEmpByName(){
		return(input)->empRepo.showAll().stream().filter(employee -> employee.getName().equals(input)).collect(Collectors.toList());
	}

	public static void main(String[] args) {
		SpringApplication.run(LamWithDynamoDbApplication.class, args);
	}
}
