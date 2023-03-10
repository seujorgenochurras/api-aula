package com.apiaula.tutorial.apiaula.domain.service;

import com.apiaula.tutorial.apiaula.domain.models.Delivery;
import com.apiaula.tutorial.apiaula.domain.models.Occurrence;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterOccurrenceService {

   @Autowired
   private SearchDeliveryService searchDeliveryService;

   @Transactional
   public Occurrence register(Long deliveryID, String description){
      Delivery delivery = searchDeliveryService.search(deliveryID);
      return delivery.addOccurrence(description);
   }
}
