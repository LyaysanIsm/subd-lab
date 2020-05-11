package ru.ulstu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ulstu.model.Supply;

public interface SupplyRepository extends JpaRepository<Supply, Integer> {
}
