package com.apiaula.tutorial.apiaula.domain.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;

@Embeddable
public class Recipient {

   @Column(name = "recipient_name")
   @NotBlank
   private String name;
   @Column(name = "recipient_address")
   @NotBlank
   private String address;
   @Column(name = "recipient_phone")
   @NotBlank
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
