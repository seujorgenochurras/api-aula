package com.apiaula.tutorial.apiaula.domain.service;

import com.apiaula.tutorial.apiaula.domain.Repository.DeliveryRepository;
import com.apiaula.tutorial.apiaula.domain.models.Delivery;
import com.apiaula.tutorial.apiaula.domain.models.DeliveryStatus;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArrivedDeliveryService {

   @Autowired
   private SearchDeliveryService searchDeliveryService;
   @Autowired
   private DeliveryRepository deliveryRepository;


   @Transactional
   public void setArrived(long deliveryId){
      Delivery delivery = searchDeliveryService.search(deliveryId);
      delivery.setArrived();
      deliveryRepository.save(delivery);
   }
}
