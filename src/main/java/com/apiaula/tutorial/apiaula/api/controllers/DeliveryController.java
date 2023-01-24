package com.apiaula.tutorial.apiaula.api.controllers;


import com.apiaula.tutorial.apiaula.api.assembler.DeliveryAssembler;
import com.apiaula.tutorial.apiaula.api.model.DeliveryModel;
import com.apiaula.tutorial.apiaula.api.model.request.DeliveryRequestModel;
import com.apiaula.tutorial.apiaula.domain.Repository.DeliveryRepository;
import com.apiaula.tutorial.apiaula.domain.models.Delivery;
import com.apiaula.tutorial.apiaula.domain.service.ArrivedDeliveryService;
import com.apiaula.tutorial.apiaula.domain.service.RequestDeliveryService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/deliveries")
public class DeliveryController {

   private final RequestDeliveryService deliveryService;

   private final DeliveryRepository deliveryRepository;

   private final DeliveryAssembler deliveryAssembler;

   private final ArrivedDeliveryService arrivedDeliveryService;

   //todo remove this latter, just add @AutoWired to this.deliveryService
   public DeliveryController(RequestDeliveryService deliveryService, DeliveryRepository respository, DeliveryAssembler deliveryAssembler
   , ArrivedDeliveryService arrivedDeliveryService){
      this.deliveryService = deliveryService;
      this.deliveryRepository = respository;
      this.deliveryAssembler = deliveryAssembler;
      this.arrivedDeliveryService = arrivedDeliveryService;
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
      return deliveryAssembler.toCollectionModel(deliveryRepository.findAll());
   }

   @GetMapping("/{deliveryID}")
   public ResponseEntity<DeliveryModel> findByID(@PathVariable long deliveryID){
       return deliveryRepository.findById(deliveryID).map(model ->ResponseEntity.ok(deliveryAssembler.toModel(model))
      ).orElse(ResponseEntity.notFound().build());
   }
   @PutMapping("/{deliveryId}/arrive")
   @ResponseStatus(HttpStatus.NO_CONTENT)
   public void arrive(@PathVariable long deliveryId){
      arrivedDeliveryService.setArrived(deliveryId);
   }
}
