package com.GabrielsSena.Web.Service.Service;

import com.GabrielsSena.Web.Service.Entities.Order;
import com.GabrielsSena.Web.Service.Entities.User;
import com.GabrielsSena.Web.Service.Entities.enums.OrderStatus;
import com.GabrielsSena.Web.Service.Repository.OrderRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Order findById(Long id){
        return orderRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Pedido não encontrado"));
    }

    public List<Order> findByMomentBetweet(Instant start, Instant end){
        return orderRepository.findByMomentBetween(start, end);
    }

    public List<Order> findByUser(User user){
        return orderRepository.findByUser(user);
    }

    public void saveOrder(Order order){
        orderRepository.save(order);
    }

    public void deleteOrderById(Long id){
        orderRepository.deleteById(id);
    }


    public void updateStatusById(OrderStatus status, Long id){
        Order obj = orderRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Order not found"));
        obj.setStatus(status);
        orderRepository.save(obj);
    }


}
