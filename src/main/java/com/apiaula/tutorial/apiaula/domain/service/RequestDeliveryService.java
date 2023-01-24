package com.apiaula.tutorial.apiaula.domain.service;

import com.apiaula.tutorial.apiaula.domain.Repository.DeliveryRepository;
import com.apiaula.tutorial.apiaula.domain.models.Client;
import com.apiaula.tutorial.apiaula.domain.models.Delivery;
import com.apiaula.tutorial.apiaula.domain.models.DeliveryStatus;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;

@Service
public class RequestDeliveryService {
   private final DeliveryRepository deliveryRepository;
   private final ClientService clientService;

   public RequestDeliveryService(DeliveryRepository deliveryRepository,
                                 ClientService clientService) {
      this.deliveryRepository = deliveryRepository;
      this.clientService = clientService;
   }

   @Transactional
   public Delivery request(Delivery delivery){
      Client client = clientService.searchClientByID(delivery.getClient().getId());
      delivery.setStatus(DeliveryStatus.PENDING);
      delivery.setDeliveryStarted(OffsetDateTime.now());
      delivery.setClient(client);

      return deliveryRepository.save(delivery);
   }

}
