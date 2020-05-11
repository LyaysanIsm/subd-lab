package ru.ulstu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ulstu.model.Provider;

import java.util.List;

public interface ProviderRepository extends JpaRepository<Provider, Integer> {
    List<Provider> findByNameOrganization(String nameOrganization);
}
