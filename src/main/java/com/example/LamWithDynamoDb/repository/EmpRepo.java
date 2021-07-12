package com.example.LamWithDynamoDb.repository;

import com.example.LamWithDynamoDb.entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
public class EmpRepo {
    public List<Employee> showAll(){
        return Stream.of(
                new Employee("1","karthik","Asst-Eng","24000"),
                new Employee("2","Arjun","School-boy","000"),
                new Employee("3","Guru","Asso-SE","26000")
        ).collect(Collectors.toList());
    }
}
