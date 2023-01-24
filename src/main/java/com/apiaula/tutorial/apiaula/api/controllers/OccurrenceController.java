package com.apiaula.tutorial.apiaula.api.controllers;

import com.apiaula.tutorial.apiaula.api.assembler.OccurrenceAssembler;
import com.apiaula.tutorial.apiaula.api.model.OccurrenceModel;
import com.apiaula.tutorial.apiaula.api.model.request.OccurrenceRequest;
import com.apiaula.tutorial.apiaula.domain.models.Delivery;
import com.apiaula.tutorial.apiaula.domain.models.Occurrence;
import com.apiaula.tutorial.apiaula.domain.services.RegisterOccurrenceService;
import com.apiaula.tutorial.apiaula.domain.services.SearchDeliveryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/deliveries/{deliveryID}/occurrences")
public class OccurrenceController {
   @Autowired
   private RegisterOccurrenceService occurrenceService;

   @Autowired
   private OccurrenceAssembler occurrenceAssembler;
   @Autowired
   private SearchDeliveryService searchDeliveryService;

   @PostMapping
   public OccurrenceModel createOccurrence(@PathVariable long deliveryID, @RequestBody @Valid OccurrenceRequest occurrenceRequest){
      Occurrence occurrence = occurrenceService.register(deliveryID, occurrenceRequest.getDescription());
      return occurrenceAssembler.toModel(occurrence);
   }

   @GetMapping
   public List<OccurrenceModel> getAllOccurrences(@PathVariable long deliveryID){
      Delivery delivery = searchDeliveryService.search(deliveryID);
      return occurrenceAssembler.toCollectionModel(delivery.getOccurrencesList());
   }
}
