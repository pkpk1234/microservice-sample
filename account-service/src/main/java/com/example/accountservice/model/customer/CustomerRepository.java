package com.example.accountservice.model.customer;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by pkpk1234 on 2017/5/23.
 */
public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
