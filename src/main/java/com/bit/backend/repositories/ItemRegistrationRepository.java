package com.bit.backend.repositories;

import com.bit.backend.entities.ItemRegistrationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

public interface ItemRegistrationRepository extends JpaRepository<ItemRegistrationEntity, Long> {

    @Query(value = "SELECT i.item_id, i.item_name, i.category, g.expdate, s.added_date, c.qty " +
                    "FROM ems.item_reg AS i " +
                    "JOIN ems.grn_added_table AS g ON i.id = g.itemid " +
                    "JOIN ems.grn_summary AS s ON g.grnno = s.grnno " +
                    "JOIN ems.stock AS c ON i.id = c.stock_itemid " +
                    "LIMIT 0, 1000",
            nativeQuery = true
    )
    List<Object[]> itemReport();

}
