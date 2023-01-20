package com.apiaula.tutorial.apiaula.ApiExceptionHandler;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class GenericErrorResponse {
   private int errorCode;
   private String description;

   public List<ErrorColumns> getErrors() {
      return errors;
   }

   public void setErrors(List<ErrorColumns> errors) {
      this.errors = errors;
   }
   public void addError(ErrorColumns errorColumns){
      this.errors.add(errorColumns);
   }

   private LocalDateTime hour;
   private List<ErrorColumns> errors = new ArrayList<>();

   public GenericErrorResponse(int errorCode, String description, LocalDateTime hour, List<ErrorColumns> errors) {
      this.errorCode = errorCode;
      this.description = description;
      this.hour = hour;
      this.errors = errors;
   }

   public GenericErrorResponse(int errorCode, String description, LocalDateTime hour) {
      this.errorCode = errorCode;
      this.description = description;
      this.hour = hour;
   }

   public int getErrorCode() {
      return errorCode;
   }

   public void setErrorCode(int errorCode) {
      this.errorCode = errorCode;
   }

   public String getDescription() {
      return description;
   }

   public void setDescription(String description) {
      this.description = description;
   }

   public LocalDateTime getHour() {
      return hour;
   }

   public void setHour(LocalDateTime hour) {
      this.hour = hour;
   }


   public GenericErrorResponse() {
   }

   public static class ErrorColumns{
      private String name;
      private String message;
      public String getName() {
         return name;
      }

      public void setName(String name) {
         this.name = name;
      }

      public String getMessage() {
         return message;
      }

      public void setMessage(String message) {
         this.message = message;
      }

      public ErrorColumns(String name, String message) {
         this.name = name;
         this.message = message;
      }
   }
}
