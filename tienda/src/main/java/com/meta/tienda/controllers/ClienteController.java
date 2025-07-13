package com.meta.tienda.controllers;

import com.meta.tienda.entidades.Cliente;
import com.meta.tienda.excepciones.DatosNoValidosException;
import com.meta.tienda.repositories.ClienteRepository;
import com.meta.tienda.services.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tienda")
public class ClienteController {
    @Autowired
    ClienteService clienteService;
    @GetMapping("/clientes")
    public ResponseEntity<List<Cliente>> getClientes(){
        List<Cliente> clientes = clienteService.getClientes();
        return ResponseEntity.ok(clientes);
    }

   @PostMapping("/clientes")
    public ResponseEntity<?> agregarCliente(@Valid @RequestBody Cliente cliente, BindingResult result){
       if(result.hasErrors()) {
            throw new DatosNoValidosException("Error de validacion", result);
       }
       Cliente clienteAgregado = clienteService.agregarCliente(cliente);
       return ResponseEntity.ok(clienteAgregado);
    }

    @PutMapping("/clientes/{id}")
    public ResponseEntity<?> actualizarCliente(@PathVariable int id, @Valid @RequestBody Cliente actualizarCliente, BindingResult result){
        if(result.hasErrors()) {
            throw new DatosNoValidosException("Error de validacion", result);
        }
        Cliente cliente = clienteService.actualizarCliente(id, actualizarCliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
    }

    @DeleteMapping("/clientes/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void eliminarCliente(@PathVariable int id){
        clienteService.eliminarCliente(id);

    }



}
