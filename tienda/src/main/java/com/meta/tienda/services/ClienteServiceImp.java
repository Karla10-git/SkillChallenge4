package com.meta.tienda.services;
import com.meta.tienda.entidades.Cliente;
import com.meta.tienda.excepciones.DatosNoValidosException;
import com.meta.tienda.excepciones.NotFoundException;
import com.meta.tienda.repositories.ClienteRepository;
import org.hibernate.ResourceClosedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.NotActiveException;
import java.util.List;

@Service
public class ClienteServiceImp implements ClienteService{
    @Autowired
    ClienteRepository clienteRepository;
    @Override
    public List<Cliente> getClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente buscarClienteId(int id) {
        Cliente cliente = clienteRepository.findById(id).orElseThrow(
                () -> new ResourceClosedException("Cliente no encontrado")
        );
        return clienteRepository.findAllById(id);
    }

    @Override
    public Cliente agregarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }
    @Override
    public Cliente actualizarCliente(int id, Cliente actualizarCliente ){
            Cliente cliente = clienteRepository.findById(id).orElseThrow(
                    () ->  new NotFoundException("El cliente no existe")
            );
            cliente.setNombre(actualizarCliente.getNombre());
            cliente.setDireccion(actualizarCliente.getDireccion());
            cliente.setEdad(actualizarCliente.getEdad());
            return clienteRepository.save(cliente);
    }
    @Override
    public void eliminarCliente(int id) {
        if (clienteRepository.findById(id).isEmpty()){
            throw new NotFoundException("El cliente no existe");
        }
        clienteRepository.deleteById(id);
    }

}
