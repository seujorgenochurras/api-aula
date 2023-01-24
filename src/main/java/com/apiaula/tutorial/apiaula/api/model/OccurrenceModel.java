package com.apiaula.tutorial.apiaula.api.model;

import java.time.OffsetDateTime;

public class OccurrenceModel {
   private long id;
   private String description;

   public long getId() {
      return id;
   }

   public void setId(long id) {
      this.id = id;
   }

   public String getDescription() {
      return description;
   }

   public void setDescription(String description) {
      this.description = description;
   }

   public OffsetDateTime getDateRegister() {
      return dateRegister;
   }

   public void setDateRegister(OffsetDateTime dateRegister) {
      this.dateRegister = dateRegister;
   }

   private OffsetDateTime dateRegister;
}
