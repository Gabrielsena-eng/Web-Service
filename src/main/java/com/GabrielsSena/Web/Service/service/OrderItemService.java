package com.GabrielsSena.Web.Service.Service;

import com.GabrielsSena.Web.Service.Entities.Order;
import com.GabrielsSena.Web.Service.Entities.OrderItem;
import com.GabrielsSena.Web.Service.Entities.Product;
import com.GabrielsSena.Web.Service.Entities.User;
import com.GabrielsSena.Web.Service.Entities.enums.OrderStatus;
import com.GabrielsSena.Web.Service.Repository.OrderItemRepository;
import com.GabrielsSena.Web.Service.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class OrderItemService {

    @Autowired
    private OrderItemRepository itemRepository;

    @Autowired
    private ProductService productService;

    public OrderItem findById(Long id){
        return itemRepository.findById(id).orElseThrow(() ->
                new RuntimeException("OrderItem not found"));
    }

    public List<OrderItem> findByOrder(Order order){
        return itemRepository.findByOrder(order);
    }

    public OrderItem replaceProductInOrderItem(Long orderItemId, Long productId){
        OrderItem item = itemRepository.findById(orderItemId).orElseThrow(() ->
                new RuntimeException("Order item not Found"));
        Product product = productService.findById(productId);
        item.setProduct(product);

        return item;
    }



}
