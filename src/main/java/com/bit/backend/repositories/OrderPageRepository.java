package com.bit.backend.repositories;

import com.bit.backend.entities.OrderPageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderPageRepository extends JpaRepository<OrderPageEntity, Long> {
//    @Query(nativeQuery = true, value = "SELECT * FROM Order_table ot JOIN Prod_Reg p ON ot.productId")
//    List<OrderPageEntity> findAllByProdReg();

}
