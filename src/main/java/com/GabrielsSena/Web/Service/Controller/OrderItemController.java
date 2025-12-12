package com.GabrielsSena.Web.Service.Controller;

import com.GabrielsSena.Web.Service.Entities.Order;
import com.GabrielsSena.Web.Service.Entities.OrderItem;
import com.GabrielsSena.Web.Service.Service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/orderitems")
public class OrderItemController {

    @Autowired
    private OrderItemService orderItemService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<OrderItem> findById(Long id){
        return ResponseEntity.ok(orderItemService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<OrderItem>> findByOrderId(Long orderId){
        return ResponseEntity.ok(orderItemService.findByOrderId(orderId));
    }

}
