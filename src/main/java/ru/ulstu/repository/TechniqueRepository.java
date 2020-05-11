package ru.ulstu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ulstu.model.Technique;

public interface TechniqueRepository extends JpaRepository<Technique, Integer> {
}
