package com.apiaula.tutorial.apiaula.domain.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Delivery {

   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Id
   private long id;
   @ManyToOne
   @JoinColumn(name = "client_id")
   private Client client;
   @Embedded
   private Recipient recipient;

   @Column(name = "delivery_date")
   @JsonProperty(access = JsonProperty.Access.READ_ONLY)
   private LocalDateTime deliveryDate;
   @Column(name = "delivery_arrived")
   @JsonProperty(access = JsonProperty.Access.READ_ONLY)
   private LocalDateTime deliveryArrive;


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

   public LocalDateTime getDeliveryDate() {
      return deliveryDate;
   }

   public void setDeliveryDate(LocalDateTime deliveryDate) {
      this.deliveryDate = deliveryDate;
   }

   public LocalDateTime getDeliveryArrive() {
      return deliveryArrive;
   }

   public void setDeliveryArrive(LocalDateTime deliveryArrive) {
      this.deliveryArrive = deliveryArrive;
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
