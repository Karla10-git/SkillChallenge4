package com.meta.tienda.services;

import com.meta.tienda.entidades.Producto;

import java.util.List;

public interface ProductoService {
    List<Producto> getProductos();
    Producto agregarProducto(Producto producto);
    Producto actualizarProducto(int id, Producto producto);
    void eliminarProducto(int id);

}
