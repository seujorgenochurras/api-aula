package com.apiaula.tutorial.apiaula.domain.models;

import com.apiaula.tutorial.apiaula.domain.Validations.ValidationGroup;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.groups.ConvertGroup;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Entity
public class Delivery {

   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Id
   private long id;
   @ManyToOne
   @Valid
   @ConvertGroup(to = ValidationGroup.ClientID.class)
   @NotNull
   @JoinColumn(name = "client_id")
   private Client client;
   @Embedded
   @Valid
   @NotNull
   private Recipient recipient;

   @Column(name = "delivery_date")
   @JsonProperty(access = JsonProperty.Access.READ_ONLY)
   private OffsetDateTime deliveryStarted;
   @Column(name = "delivery_arrived")
   @JsonProperty(access = JsonProperty.Access.READ_ONLY)
   private OffsetDateTime deliveryArrived;
   @NotNull
   private BigDecimal price;
   @Enumerated(EnumType.STRING)
   @JsonProperty(access = JsonProperty.Access.READ_ONLY)
   private DeliveryStatus status;

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (!(o instanceof Delivery delivery)) return false;

      return getId() == delivery.getId();
   }

   @Override
   public int hashCode() {
      return (int) (getId() ^ (getId() >>> 32));
   }

   public long getId() {
      return id;
   }

   public void setId(long id) {
      this.id = id;
   }

   public Client getClient() {
      return client;
   }

   public void setClient(Client client) {
      this.client = client;
   }

   public Recipient getRecipient() {
      return recipient;
   }

   public void setRecipient(Recipient recipient) {
      this.recipient = recipient;
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

   public BigDecimal getPrice() {
      return price;
   }

   public void setPrice(BigDecimal price) {
      this.price = price;
   }

   public DeliveryStatus getStatus() {
      return status;
   }

   public void setStatus(DeliveryStatus status) {
      this.status = status;
   }

}
