package com.GabrielsSena.Web.Service.Repository;

import com.GabrielsSena.Web.Service.Entities.Order;
import com.GabrielsSena.Web.Service.Entities.User;
import com.GabrielsSena.Web.Service.Entities.enums.OrderStatus;
import jakarta.transaction.Transactional;
import org.aspectj.weaver.ast.Or;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByMomentBetween(Instant start, Instant end);;
    List<Order> findByStatus(OrderStatus status);




}
