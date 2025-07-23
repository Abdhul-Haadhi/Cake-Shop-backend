package com.bit.backend.entities;

import com.bit.backend.enums.OrderStatusEnum;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Order_detials")
public class OrderDetailsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "User_id")
    private Long user;

    @Column(name = "Date")
    private LocalDate date;

    @Column(name = "total_price")
    private Integer totalPrice;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private OrderStatusEnum status;


    public OrderDetailsEntity() {
    }

    public OrderDetailsEntity(Long id, Long user, LocalDate date, Integer totalPrice, OrderStatusEnum status) {
        this.id = id;
        this.user = user;
        this.date = date;
        this.totalPrice = totalPrice;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUser() {
        return user;
    }

    public void setUser(Long user) {
        this.user = user;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    public OrderStatusEnum getStatus() {
        return status;
    }

    public void setStatus(OrderStatusEnum status) {
        this.status = status;
    }
}
