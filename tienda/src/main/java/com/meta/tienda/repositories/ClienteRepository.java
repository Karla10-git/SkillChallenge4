package com.meta.tienda.repositories;

import com.meta.tienda.entidades.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//@Repository: Marks this interface as a Spring repository.
@Repository //JpaRepository: Provides all the necessary CRUD operations like save(), findAll(), findById(), and deleteById() without needing to write them yourself.
public interface ClienteRepository extends JpaRepository <Cliente, Integer> {
    Cliente save(Cliente cliente);

    Cliente findAllById(int id);

}
