package com.meta.tienda.controllers;

import com.meta.tienda.excepciones.DatosNoValidosException;
import com.meta.tienda.excepciones.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ControllerHandlerAdvice {
   @ExceptionHandler(DatosNoValidosException.class)
    public ResponseEntity<?> validacionEntrada(DatosNoValidosException datosNoValidosException){
       Map<String, String> errores = new HashMap<>();
       datosNoValidosException.getResult().getFieldErrors().forEach(fieldError ->  errores.put(fieldError.getField(), fieldError.getDefaultMessage()));
       return ResponseEntity.badRequest().body(errores);
   }
   /*public boolean validarDireccion(int disponible, int pedido) throws ProductoInsuficienteException{
      if (disponible < pedido){
         throw new ProductoInsuficienteException("No hay suficiente producto");
      }
      return true; min 1:18
   }*/
   @ExceptionHandler(NotFoundException.class)
   public ResponseEntity<?> datosNoEncontrados(NotFoundException notFoundException){
      return ResponseEntity.notFound().build();
   }
}




