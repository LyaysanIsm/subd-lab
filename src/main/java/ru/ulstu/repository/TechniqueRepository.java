package ru.ulstu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.ulstu.model.Technique;
import ru.ulstu.model.TechniqueStatistic;

import java.util.List;

public interface TechniqueRepository extends JpaRepository<Technique, Integer> {
    List<Technique> findByAvailability(byte availability);

    @Query("SELECT new ru.ulstu.model.TechniqueStatistic(t.name) FROM Technique t WHERE t.number >= :number")
    List<TechniqueStatistic> getTechniqueStatisticByNumberMore(@Param("number") int number);
}
