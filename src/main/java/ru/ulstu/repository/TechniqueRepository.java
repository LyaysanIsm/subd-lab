package ru.ulstu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.ulstu.model.Technique;

import java.util.List;

public interface TechniqueRepository extends JpaRepository<Technique, Integer> {
    List<Technique> findByAvailability(byte availability);

    @Query("SELECT t FROM Technique t WHERE t.number >= :number")
    List<Technique> getTechniqueStatisticByNumberMore(@Param("number") int number);

    @Query("SELECT t FROM Technique t ORDER BY name ASC")
    List<Technique> getTechniqueOrder();
}
