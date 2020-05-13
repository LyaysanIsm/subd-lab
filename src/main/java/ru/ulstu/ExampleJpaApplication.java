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
        Customer customer1 = crudService.createCustomer("Mahmutova", "Albina", "Ramilevna", "89267157466", "Surova3");
        Customer customer2 = crudService.createCustomer("Efimova", "Marina", "Aleksandrovna", "80267153486", "Livanova5");
        Customer customer3 = crudService.createCustomer("Novikov", "Dmitriy", "Pavlovich", "85267157434", "Tupoleva7");

        Provider provider = crudService.createProvider("Progress", "Matveeva", "Ksenia", "Alekseevna", "89267157466", "Goncharova5");
        Provider provider2 = crudService.createProvider("Wall", "Petrov", "Vlad", "Matveevich", "89267157466", "Tuleneva3");
        Provider provider3 = crudService.createProvider("Avrora", "Lagin", "Mihail", "Petrovich", "89267157466", "Sozidateley8");

        Request request = crudService.createRequest(new Date(2019-07-01), 25);
        Request request2 = crudService.createRequest(new Date(2019-05-10), 10);
        Request request3 = crudService.createRequest(new Date(2019-03-11), 8);

        Supply supply = crudService.createSupply(new Date(2019-07-10), 25);
        Supply supply2 = crudService.createSupply(new Date(2019-05-15), 10);
        Supply supply3 = crudService.createSupply(new Date(2019-03-19), 8);

        Technique technique = crudService.createTechnique("Computer", 50, (byte)1);
        Technique technique2 = crudService.createTechnique("Printer", 20, (byte)1);
        Technique technique3 = crudService.createTechnique("Monitor", 30, (byte)1);


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
