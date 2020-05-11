package ru.ulstu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ulstu.model.Provider;

public interface ProviderRepository extends JpaRepository<Provider, Integer> {
}
