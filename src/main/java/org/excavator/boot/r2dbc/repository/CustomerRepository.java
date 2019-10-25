package org.excavator.boot.r2dbc.repository;

import org.excavator.boot.r2dbc.entity.Customer;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface CustomerRepository extends ReactiveCrudRepository<Customer, Long> {

} 
