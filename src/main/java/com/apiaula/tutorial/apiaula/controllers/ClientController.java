package com.apiaula.tutorial.apiaula.controllers;

import com.apiaula.tutorial.apiaula.models.Client;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class ClientController {

   @GetMapping("clients")
   public static List<Client> clients(){
      var cliente1 = new Client(1L, "Jhon", "jhondoe@oiawjdoijawdaw", "09187237812931079283");
      var cliente2 = new Client(2L, "jahandeoefoda", "jahandeoefodae@oiawjdoijawdaw", "jahandeoefoda7812931079283");
      return Arrays.asList(cliente2, cliente1);
   }

}
