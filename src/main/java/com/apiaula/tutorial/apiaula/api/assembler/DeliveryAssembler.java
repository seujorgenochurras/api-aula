package com.apiaula.tutorial.apiaula.api.assembler;

import com.apiaula.tutorial.apiaula.api.model.DeliveryModel;
import com.apiaula.tutorial.apiaula.api.model.request.DeliveryRequestModel;
import com.apiaula.tutorial.apiaula.domain.models.Delivery;
import org.hibernate.annotations.Comment;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DeliveryAssembler {
   @Autowired
   private ModelMapper modelMapper;

   public DeliveryModel toModel(Delivery delivery){
      return modelMapper.map(delivery, DeliveryModel.class);
   }
   public List<DeliveryModel> toCollectionModel(List<Delivery> deliveries){
      return deliveries.stream()
              .map(this::toModel)
              .collect(Collectors.toList());
   }
   public Delivery toEntity(DeliveryRequestModel model){
      return modelMapper.map(model, Delivery.class);
   }

}

