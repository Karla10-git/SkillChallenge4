package com.meta.tienda.controllers;

import com.meta.tienda.entidades.Producto;
import com.meta.tienda.excepciones.DatosNoValidosException;
import com.meta.tienda.services.ProductoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tienda")
public class ProductoController {
    @Autowired
    ProductoService productoService;
    @GetMapping("/productos")
    public ResponseEntity<List<Producto>> getProductos(){
        List<Producto> productos = productoService.getProductos();
        return ResponseEntity.ok(productos);
    }

    @PostMapping("/productos")
    public ResponseEntity<?> agregarProducto(@Valid @RequestBody Producto producto, BindingResult result) {
        if (result.hasErrors()) {
            throw new DatosNoValidosException("Error de validacion", result);
        }
        Producto productoAgregado = productoService.agregarProducto(producto);
        return ResponseEntity.ok(productoAgregado);
    }

    @PutMapping("/productos/{id}/")
    public ResponseEntity<Producto> actualizarProducto(@PathVariable ("idProducto") int id, @RequestBody Producto actualizarProducto){
        Producto producto = productoService.actualizarProducto(id, actualizarProducto);
        return ResponseEntity.status(HttpStatus.CREATED).body(producto);
    }

    @DeleteMapping("/productos/{id}/")
    public ResponseEntity<String> eliminarProducto(@PathVariable int id) {
        productoService.eliminarProducto(id);
        //return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return ResponseEntity.ok("Producto eliminado.");
    }


}
