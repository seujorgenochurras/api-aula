package com.apiaula.tutorial.apiaula.api.model.request;

import jakarta.validation.constraints.NotNull;

public class RecipientRequest {
   @NotNull
   private String name;
   @NotNull
   private String address;
   @NotNull
   private String phone;


   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getAddress() {
      return address;
   }

   public void setAddress(String address) {
      this.address = address;
   }

   public String getPhone() {
      return phone;
   }

   public void setPhone(String phone) {
      this.phone = phone;
   }
}
