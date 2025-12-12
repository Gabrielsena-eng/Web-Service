package com.GabrielsSena.Web.Service.Controller;

import com.GabrielsSena.Web.Service.Entities.Order;
import com.GabrielsSena.Web.Service.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {

    @Autowired
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Order> findById(@PathVariable Long id){
      return ResponseEntity.ok(orderService.findById(id));
    }

    @GetMapping(params = {"start", "end"})
    public ResponseEntity<List<Order>> finByMomentBetween(
            @RequestParam Instant start,
            @RequestParam Instant end
    ) {
        return ResponseEntity.ok(orderService.findByMomentBetween(start, end));
    }

    @GetMapping("/{userId}")
    public  ResponseEntity<List<Order>> finByUserId(@PathVariable Long userId){
        return ResponseEntity.ok(orderService.findByUserId(userId));
    }

    @PutMapping
    public ResponseEntity<Order> saveOrder(@RequestParam Order order){
         orderService.saveOrder(order);
         return ResponseEntity.ok().build();

    }
}
