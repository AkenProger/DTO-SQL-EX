package com.example.sqlex1.dao;

import com.example.sqlex1.enums.ProductType;
import com.example.sqlex1.models.Product;
import com.example.sqlex1.models.tasks_dto.Task8Maker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {

    List<Product> findDistinctMakerByType(ProductType productType);

    @Query("select distinct new com.example.sqlex1.models.tasks_dto.Task8Maker(p.maker) from Product p where p.type = ?1 " +
            "and p.maker not in (select p1.maker from Product p1 where p1.type = ?2)")
    List<Task8Maker> findByPcMaker(ProductType productType, ProductType productType1);
}
