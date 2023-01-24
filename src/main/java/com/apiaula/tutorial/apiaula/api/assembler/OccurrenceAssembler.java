package com.apiaula.tutorial.apiaula.api.assembler;

import com.apiaula.tutorial.apiaula.api.model.OccurrenceModel;
import com.apiaula.tutorial.apiaula.domain.models.Occurrence;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OccurrenceAssembler {

   @Autowired
   private ModelMapper modelMapper;

   public OccurrenceModel toModel(Occurrence occurrence){
      return modelMapper.map(occurrence, OccurrenceModel.class);
   }
   public List<OccurrenceModel> toCollectionModel(List<Occurrence> occurrences){
      return occurrences.stream().map(this::toModel).collect(Collectors.toList());
   }
}
