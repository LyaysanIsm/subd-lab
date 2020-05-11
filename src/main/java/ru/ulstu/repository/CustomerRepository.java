package ru.ulstu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.ulstu.model.Customer;
import ru.ulstu.model.CustomerStatistic;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    List<Customer> findByAddress(String address);

    @Query("SELECT new ru.ulstu.model.CustomerStatistic(u.name) FROM Customer c WHERE c.surname LIKE %:firstLetter%")
    List<CustomerStatistic> getCustomerStatisticStartName(@Param("firstLetter") String firstLetter);
}
