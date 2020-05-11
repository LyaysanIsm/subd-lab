package ru.ulstu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ulstu.model.Request;

public interface RequestRepository extends JpaRepository<Request, Integer> {
}
