package com.GabrielsSena.Web.Service.Controller;

import com.GabrielsSena.Web.Service.Entities.Payment;
import com.GabrielsSena.Web.Service.Service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping(value = "/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Payment> findById(@PathVariable Long id){
        return ResponseEntity.ok(paymentService.findById(id));
    }

    @GetMapping(params = {"start", "end"})
    public ResponseEntity<List<Payment>> findByMomentBetween(
            @RequestParam Instant start,
            @RequestParam Instant end
    ){
        return ResponseEntity.ok(paymentService.findByMomentBetween(start, end));
    }

    @GetMapping
    public ResponseEntity<List<Payment>> findAll(){
        return ResponseEntity.ok(paymentService.findAll());
    }

    @PostMapping
    public ResponseEntity<Payment> savePayment(@RequestBody Payment payment){
       paymentService.savePayment(payment);
       return ResponseEntity.ok().build();
    }
}
