package com.example.pizza;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class pizzaservice {
    private final List<pizzaorder> history = new ArrayList<>();
    private long id = 1;

    public void makeorder(pizzaorder p){
        double base = switch (p.getSize()){
            case "small" -> 8.00;
            case "medium" -> 10.00;
            case "large" -> 12.00;
            default -> 0;
        };

        //topping price
        double topping = p.getToppings().size() *1.25;
        double addedprice = (base+topping);
        double firsttotal = addedprice * p.getQuantity();

        //discount price
        double discount = (p.getQuantity() > 3) ? firsttotal - p.getQuantity() * 0.10 : 0.0;

        //tax
        double delivery = p.isDelivery() ? 3.99 : 0.0;
        double tax = (firsttotal - discount)*0.13;

        p.setId(id++);
        p.setSubtotal(firsttotal);
        p.setDiscount(discount);
        p.setTax(tax);
        p.setTotal(firsttotal-discount+tax+delivery);
        p.setOrderTime(LocalDateTime.now());

        history.add(p);

    }

    public List<pizzaorder> getOrders() {
        return history;
    }
}
