package com.apiaula.tutorial.apiaula.domain.models;

import com.apiaula.tutorial.apiaula.domain.Validations.ValidationGroup;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Objects;

@Entity
@Table(name = "clients")
public class Client {
   @Id
   @NotNull(groups = ValidationGroup.ClientID.class)
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long id;
@NotNull
@Size(max= 60)
   @Column(name = "nome")
   private String name;
@Email
@Size(max= 255)
@Column(name = "email")
   private String email;
   @Size(max= 33)
   @Column(name = "fone")
   private String telefone;

   public Client(String name, String email, String telefone) {
      this.name = name;
      this.email = email;
      this.telefone = telefone;
   }
   public Client(){}

   public long getId() {
      return id;
   }

   public void setId(long id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public String getTelefone() {
      return telefone;
   }

   public void setTelefone(String telefone) {
      this.telefone = telefone;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (!(o instanceof Client client)) return false;

      return getId() == client.getId();
   }
   @Override
   public int hashCode() {
      return Objects.hash(id);
   }
}
