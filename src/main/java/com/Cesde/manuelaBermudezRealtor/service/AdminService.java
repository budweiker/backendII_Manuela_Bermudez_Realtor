package com.Cesde.manuelaBermudezRealtor.service;

import com.Cesde.manuelaBermudezRealtor.modelo.MAdmin;
import com.Cesde.manuelaBermudezRealtor.repositories.IAdmin;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class AdminService {
    private final IAdmin repository;

    public AdminService(IAdmin repository) { this.repository = repository; }
    public MAdmin crear(MAdmin admin) { return repository.save(admin); }
    public List<MAdmin> listar() { return repository.findAll(); }
    public MAdmin buscar(Integer id) {
        return repository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Administrador no encontrado"));
    }
    public MAdmin actualizar(Integer id, MAdmin cambios) {
        MAdmin admin = buscar(id);
        admin.setNombre(cambios.getNombre());
        admin.setApellido(cambios.getApellido());
        admin.setPassword(cambios.getPassword());
        admin.setTelefono(cambios.getTelefono());
        admin.setCorreo(cambios.getCorreo());
        admin.setStatus(cambios.isStatus());
        admin.setAdminType(cambios.getAdminType());
        return repository.save(admin);
    }
    public void eliminar(Integer id) { repository.delete(buscar(id)); }
}