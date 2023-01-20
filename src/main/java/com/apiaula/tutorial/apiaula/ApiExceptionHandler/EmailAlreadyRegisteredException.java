package com.apiaula.tutorial.apiaula.ApiExceptionHandler;


public class EmailAlreadyRegisteredException extends RuntimeException{
   public EmailAlreadyRegisteredException(){
      super("Email is been used by another user ");
   }

   public EmailAlreadyRegisteredException(String message){
      super(message);
   }

}
