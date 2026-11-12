package com.Cesde.manuelaBermudezRealtor.service;

import com.Cesde.manuelaBermudezRealtor.modelo.MProperty;
import com.Cesde.manuelaBermudezRealtor.repositories.IProperty;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class PropertyService {
    private final IProperty repository;

    public PropertyService(IProperty repository) { this.repository = repository; }
    public MProperty crear(MProperty property) { return repository.save(property); }
    public List<MProperty> listar() { return repository.findAll(); }
    public MProperty buscar(Integer id) {
        return repository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Propiedad no encontrada"));
    }
    public MProperty actualizar(Integer id, MProperty cambios) {
        MProperty property = buscar(id);
        property.setPropiedadValor(cambios.getPropiedadValor());
        property.setUbicacionPropiedad(cambios.getUbicacionPropiedad());
        property.setPropiedadDireccion(cambios.getPropiedadDireccion());
        property.setHabitaciones(cambios.getHabitaciones());
        property.setBanos(cambios.getBanos());
        property.setArea(cambios.getArea());
        property.setEstrato(cambios.getEstrato());
        property.setBarrio(cambios.getBarrio());
        property.setMunicipio(cambios.getMunicipio());
        property.setEstado(cambios.getEstado());
        return repository.save(property);
    }
    public void eliminar(Integer id) { repository.delete(buscar(id)); }
    public List<MProperty> buscarPorBarrio(String barrio) { return repository.findByBarrioIgnoreCase(barrio); }
    public List<MProperty> buscarPorEstrato(int estrato) { return repository.findByEstrato(estrato); }
    public List<MProperty> buscarPorMunicipio(String municipio) { return repository.findByMunicipioIgnoreCase(municipio); }
    public List<MProperty> buscarPorRango(float min, float max) {
        if (min > max) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El valor minimo supera al maximo");
        return repository.findByPropiedadValorBetween(min, max);
    }
}