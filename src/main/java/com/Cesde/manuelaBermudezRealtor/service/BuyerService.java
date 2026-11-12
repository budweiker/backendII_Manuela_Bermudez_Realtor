package com.Cesde.manuelaBermudezRealtor.service;

import com.Cesde.manuelaBermudezRealtor.modelo.MBuyer;
import com.Cesde.manuelaBermudezRealtor.repositories.IBuyer;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class BuyerService {
    private final IBuyer repository;

    public BuyerService(IBuyer repository) { this.repository = repository; }
    public MBuyer crear(MBuyer buyer) { return repository.save(buyer); }
    public List<MBuyer> listar() { return repository.findAll(); }
    public MBuyer buscar(Integer id) {
        return repository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Comprador no encontrado"));
    }
    public MBuyer actualizar(Integer id, MBuyer cambios) {
        MBuyer buyer = buscar(id);
        buyer.setNombre(cambios.getNombre());
        buyer.setApellido(cambios.getApellido());
        buyer.setPassword(cambios.getPassword());
        buyer.setTelefono(cambios.getTelefono());
        buyer.setCorreo(cambios.getCorreo());
        buyer.setStatus(cambios.isStatus());
        buyer.setPropiedadDeInteresActual(cambios.getPropiedadDeInteresActual());
        buyer.setBalance(cambios.getBalance());
        return repository.save(buyer);
    }
    public void eliminar(Integer id) { repository.delete(buscar(id)); }
}