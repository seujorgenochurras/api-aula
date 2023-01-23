package com.apiaula.tutorial.apiaula.api.model;

import com.apiaula.tutorial.apiaula.domain.models.Delivery;
import com.apiaula.tutorial.apiaula.domain.models.DeliveryStatus;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public class DeliveryModel {

   private Long id;
   private ClientPreviewModel client;
   private RecipientModel recipient;
   private BigDecimal price;
   private DeliveryStatus deliveryStatus;
   private OffsetDateTime deliveryStarted;
   private OffsetDateTime deliveryArrived;


   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public RecipientModel getRecipient() {
      return recipient ;
   }

   public void setRecipient(RecipientModel recipient) {
      this.recipient = recipient;
   }

   public BigDecimal getPrice() {
      return price;
   }

   public void setPrice(BigDecimal price) {
      this.price = price;
   }

   public DeliveryStatus getDeliveryStatus() {
      return deliveryStatus;
   }

   public void setDeliveryStatus(DeliveryStatus deliveryStatus) {
      this.deliveryStatus = deliveryStatus;
   }

   public OffsetDateTime getDeliveryStarted() {
      return deliveryStarted;
   }

   public void setDeliveryStarted(OffsetDateTime deliveryStarted) {
      this.deliveryStarted = deliveryStarted;
   }

   public OffsetDateTime getDeliveryArrived() {
      return deliveryArrived;
   }

   public void setDeliveryArrived(OffsetDateTime deliveryArrived) {
      this.deliveryArrived = deliveryArrived;
   }
   public ClientPreviewModel getClient() {
      return client;
   }

   public void setClient(ClientPreviewModel client) {
      this.client = client;
   }
}
