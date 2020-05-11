package ru.ulstu;

import org.dom4j.rule.Mode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import ru.ulstu.model.*;
import ru.ulstu.service.CrudService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    }
}