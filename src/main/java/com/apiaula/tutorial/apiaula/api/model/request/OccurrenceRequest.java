package com.apiaula.tutorial.apiaula.api.model.request;

import jakarta.validation.constraints.NotBlank;

public class OccurrenceRequest {

   @NotBlank
   private String description;

   public String getDescription() {
      return description;
   }

   public void setDescription(String description) {
      this.description = description;
   }
}
