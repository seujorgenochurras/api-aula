package com.apiaula.tutorial.apiaula.domain.service;

import com.apiaula.tutorial.apiaula.api.ApiExceptionHandler.EntityException;
import com.apiaula.tutorial.apiaula.domain.Repository.DeliveryRepository;
import com.apiaula.tutorial.apiaula.domain.models.Delivery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SearchDeliveryService {

   @Autowired
   private DeliveryRepository deliveryRepository;
   public Delivery search(Long id){
      return deliveryRepository.findById(id).orElseThrow(()->new EntityException("Delivery not found"));
   }

}
