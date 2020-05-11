package ru.ulstu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ulstu.model.Supply;

import java.util.List;

public interface SupplyRepository extends JpaRepository<Supply, Integer> {
    List<Supply> findByNumber(int number);
}
