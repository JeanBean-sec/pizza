package com.example.pizza;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class pizzaorder {
    private Long id;
    private String customerName;
    private String size;
    private String crust;
    private List<String> toppings = new ArrayList<>();
    private int quantity;
    private boolean delivery;
    private String deliveryAddress;
    private double subtotal;
    private double tax;
    private double discount;
    private double total;
    private LocalDateTime orderTime;



}
