package com.apiaula.tutorial.apiaula.domain.services;

import com.apiaula.tutorial.apiaula.api.ApiExceptionHandler.GenericNotFoundException;
import com.apiaula.tutorial.apiaula.domain.Repository.ClientRepository;
import com.apiaula.tutorial.apiaula.domain.models.Client;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
@Autowired
private ClientRepository clientRepository;


   public Client searchClientByID(long clientID){
   return clientRepository.findById(clientID).orElseThrow(()-> new GenericNotFoundException("Client not found"));
   }
@Transactional
   public Client save(Client client){
   boolean isEmailAlreadyUsed = clientRepository.findByEmail(client.getEmail())
           .stream()
           .anyMatch(existentClient -> !existentClient.equals(client));
   if(isEmailAlreadyUsed) throw new GenericNotFoundException("Email is been used by another user ");
   return clientRepository.save(client);
   }
@Transactional
   public void delete(long clientID){
   clientRepository.deleteById(clientID);
   }
}
