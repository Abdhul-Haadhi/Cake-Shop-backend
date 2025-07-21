package com.bit.backend.repositories;

import com.bit.backend.entities.OrderDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface OrderDetailsRepository extends JpaRepository<OrderDetailsEntity, Long> {

    @Query(value = "SELECT o.id, s.item_name, b.customer_name, b.contact_number, b.Email, b.Address, o.date " +
                    "FROM ems.order_detials AS o " +
                    "JOIN ems.order_summary as s on o.id = s.order_id " +
                    "JOIN ems.billing_table as b on o.id = b.order_id " +
                    "LIMIT 0, 1000",
            nativeQuery = true
    )
    List<Object[]> findAllOrderDetailsRaw();

    @Query(value = "SELECT ")

}
