package com.bit.backend.repositories;

import com.bit.backend.entities.StockEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface StockRepository extends JpaRepository<StockEntity, Long> {

    @Query(nativeQuery = true, value="SELECT * FROM stock WHERE stock_itemid = :itemID")
    Optional<StockEntity> findByItemIDo(@Param("itemID") long itemID);

    @Query(nativeQuery = true, value="SELECT * FROM stock WHERE stock_itemid = :itemID")
    StockEntity findByItemID(@Param("itemID") long itemID);
}
