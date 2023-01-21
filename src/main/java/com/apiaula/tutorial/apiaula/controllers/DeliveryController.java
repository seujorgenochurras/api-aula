package com.apiaula.tutorial.apiaula.controllers;


import com.apiaula.tutorial.apiaula.domain.models.Delivery;
import com.apiaula.tutorial.apiaula.domain.services.RequestDeliveryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/deliveries")
public class DeliveryController {

   private RequestDeliveryService deliveryService;

   //todo remove this latter, just add @AutoWired to this.deliveriService
   public DeliveryController(RequestDeliveryService deliveryService){
      this.deliveryService = deliveryService;
   }

   @PostMapping
   @ResponseStatus(HttpStatus.CREATED)
   public Delivery requestDelivery(@RequestBody Delivery delivery){
      return deliveryService.request(delivery);
   }

}
