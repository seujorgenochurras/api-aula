package com.apiaula.tutorial.apiaula.domain.models;

import jakarta.persistence.*;

import java.time.OffsetDateTime;

@Entity
public class Occurrence {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @ManyToOne
   private Delivery delivery;

   private String description;
   @Column(name = "date_register")
   private OffsetDateTime dateRegister;

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (!(o instanceof Occurrence that)) return false;

      return getId().equals(that.getId());
   }

   @Override
   public int hashCode() {
      return getId().hashCode();
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public Delivery getDelivery() {
      return delivery;
   }

   public void setDelivery(Delivery delivery) {
      this.delivery = delivery;
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
}
