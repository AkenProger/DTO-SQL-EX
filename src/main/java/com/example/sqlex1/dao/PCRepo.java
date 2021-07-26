package com.example.sqlex1.dao;

import com.example.sqlex1.models.PC;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
@Repository
public interface PCRepo extends JpaRepository<PC, Long> {
    List<PC> findAllByPriceLessThan(double price);

    List<PC> findByCdInAndPriceLessThan(Collection<String> cd, double price);
    @Query(value = "SELECT * FROM pc WHERE pc.speed >= ?1", nativeQuery = true)
    List<PC> findBySpeed(int speed);

}
