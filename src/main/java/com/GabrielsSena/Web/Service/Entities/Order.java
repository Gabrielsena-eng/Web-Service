package com.GabrielsSena.Web.Service.Entities;

import com.GabrielsSena.Web.Service.Entities.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.List;

import static org.springframework.web.servlet.function.ServerResponse.permanentRedirect;
import static org.springframework.web.servlet.function.ServerResponse.status;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder(toBuilder = true)
@ToString
@Table(name = "tb_order")
@EqualsAndHashCode

public class Order {

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "moment")
    private Instant moment;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> items;

    public Order(Long id, Instant moment, OrderStatus orderStatus, User user) {
        super();
        this.id = id;
        this.moment = moment;
        this.user = user;
        this.status = orderStatus;
    }

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    private Payment payment;



}
