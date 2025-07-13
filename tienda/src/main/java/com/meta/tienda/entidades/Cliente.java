package com.meta.tienda.entidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity //@Entity: Marks this class as a JPA entity, meaning it will be mapped to a table in the database.
@Table(name = "clientes")
public class Cliente {
    @Id //@Id: Specifies the primary key.
    @GeneratedValue(strategy = GenerationType.IDENTITY) //@GeneratedValue: Defines the strategy for generating primary key values automatically.
    private Integer id;
    @NotNull(message = "El nombre no debe ser nulo")
    @NotEmpty(message = "El nombre no debe estar vacio")
    @NotBlank(message = "El nombre no puede estar en blanco")
    private String nombre;
    private String direccion;
    @Min(value = 18, message = "Debes tener 18 o más años de edad para comprar")
    private Integer edad;

    public Cliente() {
    }


    public Cliente(Integer id, String nombre, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }
}
