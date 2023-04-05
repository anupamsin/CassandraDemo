package com.cybage.app.repository;

import com.cybage.app.entity.Employee;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface EmployeeRepository extends CassandraRepository<Employee,Integer> {
}
