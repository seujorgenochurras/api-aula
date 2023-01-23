package com.apiaula.tutorial.apiaula.api.controllers;


import com.apiaula.tutorial.apiaula.api.model.DeliveryModel;
import com.apiaula.tutorial.apiaula.domain.Repository.DeliveryRespository;
import com.apiaula.tutorial.apiaula.domain.models.Delivery;
import com.apiaula.tutorial.apiaula.domain.services.RequestDeliveryService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.boot.Banner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/deliveries")
public class DeliveryController {

   private RequestDeliveryService deliveryService;

   private DeliveryRespository deliveryRespository;

   private ModelMapper modelMapper;

   //todo remove this latter, just add @AutoWired to this.deliveryService
   public DeliveryController(RequestDeliveryService deliveryService, DeliveryRespository respository, ModelMapper modelMapper){
      this.deliveryService = deliveryService;
      this.deliveryRespository = respository;
      this.modelMapper = modelMapper;
   }

   @PostMapping
   @ResponseStatus(HttpStatus.CREATED)
   public Delivery requestDelivery(@Valid @RequestBody Delivery delivery){
      return deliveryService.request(delivery);
   }
@GetMapping
   public List<Delivery> getDeliveries() {
      return deliveryRespository.findAll();
   }

   @GetMapping("/{deliveryID}")
   public ResponseEntity<DeliveryModel> findByID(@PathVariable long deliveryID){
      System.out.println(deliveryID + "woidjwaijdaowij");
      return deliveryRespository.findById(deliveryID).map(model ->{
         DeliveryModel deliveryModel = modelMapper.map(model, DeliveryModel.class);
         return ResponseEntity.ok(deliveryModel);
      }).orElse(ResponseEntity.notFound().build());
   }
}
