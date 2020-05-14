package ru.ulstu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.ulstu.model.Customer;
import ru.ulstu.model.Report;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    List<Customer> findByAddress(String address);

    @Query("SELECT c FROM Customer c WHERE c.name LIKE %:firstLetter%")
    List<Customer> getCustomerStatisticStartName(@Param("firstLetter") String firstLetter);

    @Query("SELECT new ru.ulstu.model.Report(c.name,t.name,r.date,r.number) FROM Technique t JOIN t.requests r JOIN r.customer c")
    List<Report> getReports();
}
