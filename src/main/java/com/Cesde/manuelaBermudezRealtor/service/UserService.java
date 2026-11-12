package com.Cesde.manuelaBermudezRealtor.service;

import com.Cesde.manuelaBermudezRealtor.modelo.MUser;
import com.Cesde.manuelaBermudezRealtor.repositories.IUser;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UserService {
    private final IUser userRepository;

    public UserService(IUser userRepository) { this.userRepository = userRepository; }
    public MUser crear(MUser user) { return userRepository.save(user); }
    public List<MUser> listar() { return userRepository.findAll(); }
    public MUser buscar(Integer id) {
        return userRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario no encontrado"));
    }
    public MUser actualizar(Integer id, MUser cambios) {
        MUser user = buscar(id);
        user.setNombre(cambios.getNombre());
        user.setApellido(cambios.getApellido());
        user.setPassword(cambios.getPassword());
        user.setTelefono(cambios.getTelefono());
        user.setCorreo(cambios.getCorreo());
        user.setStatus(cambios.isStatus());
        return userRepository.save(user);
    }
    public void eliminar(Integer id) { userRepository.delete(buscar(id)); }
}