package com.apiaula.tutorial.apiaula.domain.services;

import com.apiaula.tutorial.apiaula.api.ApiExceptionHandler.EntityNotFoundException;
import com.apiaula.tutorial.apiaula.domain.Repository.DeliveryRespository;
import com.apiaula.tutorial.apiaula.domain.models.Delivery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SearchDeliveryService {

   @Autowired
   private DeliveryRespository deliveryRespository;
   public Delivery search(Long id){
      return deliveryRespository.findById(id).orElseThrow(()->new EntityNotFoundException("Delivery not found"));
   }

}
