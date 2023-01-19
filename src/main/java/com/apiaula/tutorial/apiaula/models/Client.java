package com.apiaula.tutorial.apiaula.models;

public class Client {
   private long id;
   private String nome, email, telefone;

   public Client(long id, String nome, String email, String telefone) {
      this.id = id;
      this.nome = nome;
      this.email = email;
      this.telefone = telefone;
   }

   public long getId() {
      return id;
   }

   public void setId(long id) {
      this.id = id;
   }

   public String getNome() {
      return nome;
   }

   public void setNome(String nome) {
      this.nome = nome;
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
}
