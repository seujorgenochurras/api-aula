package com.apiaula.tutorial.apiaula.api.controllers;


import com.apiaula.tutorial.apiaula.api.assembler.DeliveryAssembler;
import com.apiaula.tutorial.apiaula.api.model.DeliveryModel;
import com.apiaula.tutorial.apiaula.api.model.request.DeliveryRequestModel;
import com.apiaula.tutorial.apiaula.domain.Repository.DeliveryRespository;
import com.apiaula.tutorial.apiaula.domain.models.Delivery;
import com.apiaula.tutorial.apiaula.domain.services.RequestDeliveryService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/deliveries")
public class DeliveryController {

   private RequestDeliveryService deliveryService;

   private DeliveryRespository deliveryRespository;

   private DeliveryAssembler deliveryAssembler;

   //todo remove this latter, just add @AutoWired to this.deliveryService
   public DeliveryController(RequestDeliveryService deliveryService, DeliveryRespository respository, DeliveryAssembler deliveryAssembler){
      this.deliveryService = deliveryService;
      this.deliveryRespository = respository;
      this.deliveryAssembler = deliveryAssembler;
   }

   @PostMapping
   @ResponseStatus(HttpStatus.CREATED)
   public DeliveryModel requestDelivery(@Valid @RequestBody DeliveryRequestModel delivery){
      Delivery newDelivery = deliveryAssembler.toEntity(delivery);
      Delivery deliveryFormatted = deliveryService.request(newDelivery);
      return deliveryAssembler.toModel(deliveryFormatted);
   }
   @GetMapping
   public List<DeliveryModel> getDeliveries() {
      return deliveryAssembler.toCollectionModel(deliveryRespository.findAll());
   }

   @GetMapping("/{deliveryID}")
   public ResponseEntity<DeliveryModel> findByID(@PathVariable long deliveryID){
       return deliveryRespository.findById(deliveryID).map(model ->ResponseEntity.ok(deliveryAssembler.toModel(model))
      ).orElse(ResponseEntity.notFound().build());
   }
}
