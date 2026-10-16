package com.Cesde.manuelaBermudezRealtor.service;

import com.Cesde.manuelaBermudezRealtor.modelo.MBuyer;
import com.Cesde.manuelaBermudezRealtor.repositories.BuyerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    private final BuyerRepository buyerRepository;

    public ClienteService(BuyerRepository buyerRepository) {
        this.buyerRepository = buyerRepository;
    }

    public MBuyer crearCliente(MBuyer cliente) {
        return buyerRepository.save(cliente);
    }

    public List<MBuyer> listarClientes() {
        return buyerRepository.findAll();
    }

    public MBuyer buscarClientePorId(Integer id) {
        return buyerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("El cliente con la id: " + id + " no existe"));
    }

    public MBuyer actualizarCliente(Integer id, MBuyer actualizado) {
        MBuyer cliente = buscarClientePorId(id);
        cliente.setNomComprador(actualizado.getNomComprador());
        cliente.setPassword(actualizado.getPassword());
        cliente.setTelComprador(actualizado.getTelComprador());
        cliente.setCorreoComprador(actualizado.getCorreoComprador());
        cliente.setStatus(actualizado.isStatus());
        return buyerRepository.save(cliente);
    }

    public void eliminarCliente(Integer id) {
        buyerRepository.delete(buscarClientePorId(id));
    }
}