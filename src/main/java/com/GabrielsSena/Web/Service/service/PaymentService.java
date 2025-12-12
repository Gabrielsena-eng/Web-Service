package com.GabrielsSena.Web.Service.Service;

import com.GabrielsSena.Web.Service.Entities.Payment;
import com.GabrielsSena.Web.Service.Repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public Payment findById(Long id){
        return paymentRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Pagamento não encontrado"));
    }

    public List<Payment> findAll(){
        return paymentRepository.findAll();
    }

    public void savePayment(Payment payment){
        paymentRepository.save(payment);
    }

    public List<Payment> findByMomentBetween(Instant start, Instant end){
       return paymentRepository.findByMomentBetween(start, end);
    }

}
