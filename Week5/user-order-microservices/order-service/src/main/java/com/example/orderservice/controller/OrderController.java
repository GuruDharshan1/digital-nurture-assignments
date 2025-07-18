package com.example.orderservice.controller;
import com.example.orderservice.client.UserClient;
import com.example.orderservice.dto.User;
import com.example.orderservice.entity.Order;
import com.example.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserClient userClient;

    @PostMapping
    public Order create(@RequestBody Order order) {
        return orderRepository.save(order);
    }

    @GetMapping("/{id}")
    public Map<String, Object> getOrderWithUser(@PathVariable Long id) {
        Order order = orderRepository.findById(id).orElse(null);
        User user = userClient.getUserById(order.getUserId());

        Map<String, Object> response = new HashMap<>();
        response.put("order", order);
        response.put("user", user);
        return response;
    }
}