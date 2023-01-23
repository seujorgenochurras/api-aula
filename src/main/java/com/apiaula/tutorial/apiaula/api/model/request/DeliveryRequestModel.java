package com.apiaula.tutorial.apiaula.api.model.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class DeliveryRequestModel {
   @Valid
   @NotNull
   private ClientRequest client;

 @Valid
 @NotNull
 private RecipientRequest recipient;
 @NotNull
 private BigDecimal price;

 public ClientRequest getClient() {
  return client;
 }

 public void setClient(ClientRequest client) {
  this.client = client;
 }

 public RecipientRequest getRecipient() {
  return recipient;
 }

 public void setRecipient(RecipientRequest recipient) {
  this.recipient = recipient;
 }

 public BigDecimal getPrice() {
  return price;
 }

 public void setPrice(BigDecimal price) {
  this.price = price;
 }
}
