package ru.ulstu;

import org.dom4j.rule.Mode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import ru.ulstu.model.*;
import ru.ulstu.service.CrudService;

import java.util.*;

@SpringBootApplication
public class ExampleJpaApplication {
    private final CrudService crudService;

    public ExampleJpaApplication(CrudService crudService) {
        this.crudService = crudService;
    }

    public static void main(String[] args) {
        SpringApplication.run(ExampleJpaApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void onStart() {
        Customer customer1 = crudService.createCustomer("surname", "name", "patro", "123", "ulsk");
        Customer customer2 = crudService.createCustomer("surname3", "name", "patro2", "123", "ulsk");
        Customer customer3 = crudService.createCustomer("surname4", "name", "patro2", "123", "ulsk");

        Provider provider = crudService.createProvider("Google", "Stieve", "Jobs", "dasd", "421", "ulsk");
        Provider provider2 = crudService.createProvider("Apple", "Stieve", "Jobs", "dasd", "421", "ulsk");
        Provider provider3 = crudService.createProvider("ULSTU", "Stieve", "Jobs", "dasd", "421", "ulsk");

        Request request = crudService.createRequest(new Date(21344214), 52);
        Request request2 = crudService.createRequest(new Date(555555), 1);
        Request request3 = crudService.createRequest(new Date(214), 12);

        Supply supply = crudService.createSupply(new Date(21344214), 1);
        Supply supply2 = crudService.createSupply(new Date(123), 222);
        Supply supply3 = crudService.createSupply(new Date(45442), 12);

        Technique technique = crudService.createTechnique("comp", 12, (byte)1);
        Technique technique2 = crudService.createTechnique("comp2", 1, (byte)1);
        Technique technique3 = crudService.createTechnique("comp3", 24, (byte)2);


        crudService.showAllCustomers();
        crudService.showAllProviders();
        crudService.showAllRequest();
        crudService.showAllSupplies();
        crudService.showAllTechniques();

        crudService.showFirstPageOfRecords();

        crudService.showFilteredRecords();

        crudService.showStatistic();
    }
}
