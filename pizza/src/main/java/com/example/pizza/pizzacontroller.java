package com.example.pizza;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class pizzacontroller {
    private final pizzaservice pizzaorderservice;

    public pizzacontroller(pizzaservice pizzaorderservice) {
        this.pizzaorderservice = pizzaorderservice;
    }

    @GetMapping("/")
    public String showHomePage(Model model)
    {
        model.addAttribute("pizzaorder",new pizzaorder());
        return "index";
    }
    @GetMapping("/history")
    public String showHistory(Model model){
        model.addAttribute("orders",pizzaorderservice.getOrders());
        return "history";
    }
}
