package com.GabrielsSena.Web.Service.Repository;

import com.GabrielsSena.Web.Service.Entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {


    List<Payment> findByMomentBetween(Instant start, Instant end);
}
