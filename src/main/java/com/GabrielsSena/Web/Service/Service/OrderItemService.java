package com.GabrielsSena.Web.Service.Service;

import com.GabrielsSena.Web.Service.Entities.Order;
import com.GabrielsSena.Web.Service.Entities.OrderItem;
import com.GabrielsSena.Web.Service.Entities.Product;
import com.GabrielsSena.Web.Service.Entities.User;
import com.GabrielsSena.Web.Service.Entities.enums.OrderStatus;
import com.GabrielsSena.Web.Service.repository.OrderItemRepository;
import com.GabrielsSena.Web.Service.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class OrderItemService {

    @Autowired
    private OrderItemRepository itemRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductService productService;

    public OrderItem findById(Long id){
        return itemRepository.findById(id).orElseThrow(() ->
                new RuntimeException("OrderItem not found"));
    }

    public List<OrderItem> findByOrderId(Long orderId){
        Order order = orderRepository.findById(orderId).orElseThrow(() ->
                new RuntimeException("Order item not Found"));
        List<OrderItem> list = itemRepository.findAll().stream().filter(x -> x.getOrder() == order).toList();
        return list;
    }

    public OrderItem replaceProductInOrderItem(Long orderItemId, Long productId){
        OrderItem item = itemRepository.findById(orderItemId).orElseThrow(() ->
                new RuntimeException("Order item not Found"));
        Product product = productService.findById(productId);
        item.setProduct(product);

        return item;
    }



}
