package com.apiaula.tutorial.apiaula.api.ApiExceptionHandler;

public class EntityNotFoundException extends GenericNotFoundException{
   public EntityNotFoundException(String message) {
      super(message);
   }
}
