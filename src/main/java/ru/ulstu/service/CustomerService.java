package ru.ulstu.service;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import ru.ulstu.model.Customer;
import ru.ulstu.model.OffsetablePageRequest;
import ru.ulstu.model.PageableItems;
import ru.ulstu.model.Report;
import ru.ulstu.repository.CustomerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements Crud<Customer> {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer create(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer get(Integer id) {
        return customerRepository.getOne(id);
    }

    @Override
    public Optional<Customer> find(Integer id) {
        return customerRepository.findById(id);
    }

    @Override
    public PageableItems<Customer> findAll(int offset, int count) {
        final Page<Customer> page = customerRepository.findAll(new OffsetablePageRequest(offset, count));
        return new PageableItems<>(page.getTotalElements(), page.getContent());
    }

    @Override
    public Customer update(Customer customer) {
        if (customer.getId() == null) {
            throw new RuntimeException("Comment id is null");
        }
        return customerRepository.save(customer);
    }

    @Override
    public void delete(Customer customer) {
        customerRepository.delete(customer);
    }

    public List<Customer> findByAddress(String address){
        return customerRepository.findByAddress(address);
    }

    List<Customer> getCustomerStatisticStartName(String firstLetter){
        return customerRepository.getCustomerStatisticStartName(firstLetter);
    }
    public List<Report> getReports(){
        return customerRepository.getReports();
    }
}
