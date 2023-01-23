package com.apiaula.tutorial.apiaula.domain.services;

import com.apiaula.tutorial.apiaula.domain.Repository.DeliveryRespository;
import com.apiaula.tutorial.apiaula.domain.models.Client;
import com.apiaula.tutorial.apiaula.domain.models.Delivery;
import com.apiaula.tutorial.apiaula.domain.models.DeliveryStatus;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;

@Service
public class RequestDeliveryService {
   private DeliveryRespository deliveryRespository;
   private final ClientService clientService;

   public RequestDeliveryService(DeliveryRespository deliveryRespository,
                                 ClientService clientService) {
      this.deliveryRespository = deliveryRespository;
      this.clientService = clientService;
   }

   @Transactional
   public Delivery request(Delivery delivery){
      Client client = clientService.searchClientByID(delivery.getClient().getId());
      delivery.setStatus(DeliveryStatus.PENDING);
      delivery.setDeliveryStarted(OffsetDateTime.now());
      delivery.setClient(client);

      return deliveryRespository.save(delivery);
   }

}
