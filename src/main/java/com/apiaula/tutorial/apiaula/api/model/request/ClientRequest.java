package com.apiaula.tutorial.apiaula.api.model.request;

import jakarta.validation.constraints.NotNull;

public class ClientRequest {
   @NotNull
   private long id;

   public long getId() {
      return id;
   }

   public void setId(long id) {
      this.id = id;
   }
}
