package ru.ulstu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ulstu.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
