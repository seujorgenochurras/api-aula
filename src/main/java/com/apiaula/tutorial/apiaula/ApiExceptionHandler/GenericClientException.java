package com.apiaula.tutorial.apiaula.ApiExceptionHandler;


public class GenericClientException extends RuntimeException{
   public GenericClientException(){
      super("Email is been used by another user ");
   }

   public GenericClientException(String message){
      super(message);
   }

}
