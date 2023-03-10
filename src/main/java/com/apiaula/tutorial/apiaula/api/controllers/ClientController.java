package com.apiaula.tutorial.apiaula.api.controllers;

import com.apiaula.tutorial.apiaula.domain.Repository.ClientRepository;
import com.apiaula.tutorial.apiaula.domain.models.Client;
import com.apiaula.tutorial.apiaula.domain.service.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clients")
public class ClientController {

     @Autowired
     private ClientRepository clientRepository;

     @Autowired
     private ClientService clientService;
   @GetMapping
   public List<Client> list(){
      return clientRepository.findAll();
   }
   @GetMapping(value = "/{id}")
   public ResponseEntity<Client> search(@PathVariable(value = "id") Long id){
      return ResponseEntity.ok(clientService.searchClientByID(id));
   }
   @PostMapping
   @ResponseStatus(HttpStatus.CREATED)
   public Client addClient(@Valid @RequestBody Client client){
      return clientService.save(client);
   }
   @PutMapping("/{clientID}")
   public ResponseEntity<Client> changeClient(@PathVariable Long clientID, @Valid @RequestBody Client client) {
      if (!clientRepository.existsById(clientID)) {
         return ResponseEntity.notFound().build();
      }
      client.setId(clientID);
      return ResponseEntity.ok(clientService.save(client));
   }

   @DeleteMapping("/{clientID}")
   public ResponseEntity<Void> deleteClient(@PathVariable Long clientID){
      if (!clientRepository.existsById(clientID)) {
         return ResponseEntity.notFound().build();
      }
      clientRepository.deleteById(clientID);
      return ResponseEntity.noContent().build();
   }
}
