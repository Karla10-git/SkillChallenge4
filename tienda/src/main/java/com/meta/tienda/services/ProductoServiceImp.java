package com.meta.tienda.services;

import com.meta.tienda.entidades.Producto;
import com.meta.tienda.repositories.ProductoRepository;
import org.hibernate.ResourceClosedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImp implements ProductoService {
    @Autowired
    ProductoRepository productoRepository;
    @Override
    public List<Producto> getProductos() {
        return productoRepository.findAll();
    }
    @Override
    public Producto agregarProducto(Producto producto){
       return productoRepository.save(producto);
    }
    @Override
    public Producto actualizarProducto(int id, Producto actualizarProducto ){

        Producto producto = productoRepository.findById(id).orElseThrow(
                () -> new ResourceClosedException("Producto no encontrado" )
        );
        producto.setNombre(actualizarProducto.getNombre());
        producto.setDescripcion(actualizarProducto.getDescripcion());
        producto.setPrecio(actualizarProducto.getPrecio());

        return productoRepository.save(producto);
    }
    @Override
    public void eliminarProducto(int id) {
        productoRepository.deleteById(id);
    }
}
