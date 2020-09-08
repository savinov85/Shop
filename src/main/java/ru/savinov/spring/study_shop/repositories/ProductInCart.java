package ru.savinov.spring.study_shop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.savinov.spring.study_shop.entities.Product;


@Repository
public interface ProductInCart extends JpaRepository<Product, Long> {

    @Modifying
    @Query("update Product p set p.id = ?1, p.title = ?2, p.price = ?3 where p.id = ?1")
    void updateById( Long id, String title, Integer price);

}
