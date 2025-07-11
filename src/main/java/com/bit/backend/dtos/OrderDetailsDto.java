package com.bit.backend.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.util.List;

public class OrderDetailsDto {
    private long id;
    private Long user;
    private LocalDate date;
    private Integer totalPrice;
    private List<OrderItemDto> items;
    private BillingFormDto billingFormDto;

    public OrderDetailsDto() {
    }

    public OrderDetailsDto(long id, Long user, LocalDate date, Integer totalPrice, List<OrderItemDto> items, BillingFormDto billingFormDto) {
        this.id = id;
        this.user = user;
        this.date = date;
        this.totalPrice = totalPrice;
        this.items = items;
        this.billingFormDto = billingFormDto;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public List<OrderItemDto> getItems() {
        return items;
    }

    public void setItems(List<OrderItemDto> items) {
        this.items = items;
    }

    public BillingFormDto getBillingFormDto() {
        return billingFormDto;
    }

    public void setBillingFormDto(BillingFormDto billingFormDto) {
        this.billingFormDto = billingFormDto;
    }
}
