package com.kodilla.customer.repository;

import com.kodilla.customer.domain.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface CustomerRepository extends CrudRepository<Customer,Long> {
}
