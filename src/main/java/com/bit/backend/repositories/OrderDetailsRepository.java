package com.bit.backend.repositories;

import com.bit.backend.entities.OrderDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface OrderDetailsRepository extends JpaRepository<OrderDetailsEntity, Long> {

    @Query(value = "SELECT o.id, s.item_name, b.customer_name, b.contact_number, b.Email, b.Address, o.date, o.status, s.item_price, s.item_qty, s.selected_size, s.selected_color, s.customize_note " +
                    "FROM ems.order_detials AS o " +
                    "JOIN ems.order_summary as s on o.id = s.order_id " +
                    "JOIN ems.billing_table as b on o.id = b.order_id " +
                    "LIMIT 0, 1000",
            nativeQuery = true
    )
    List<Object[]> findAllOrderDetailsRaw();

    @Query(value = "SELECT o.id, s.item_name, b.customer_name, b.contact_number, b.Email, b.Address, o.date, o.status, s.item_price, s.item_qty, s.selected_size, s.selected_color, s.customize_note  " +
            "FROM ems.order_detials AS o " +
            "JOIN ems.order_summary as s on o.id = s.order_id " +
            "JOIN ems.billing_table as b on o.id = b.order_id " +
            "WHERE o.date BETWEEN :startDate AND :endDate "+
            "LIMIT 0, 1000",
            nativeQuery = true
    )
    List<Object[]> findAllOrderDetailsRawByDateRange(
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate
    );

}
