package com.Cesde.manuelaBermudezRealtor.service;

import com.Cesde.manuelaBermudezRealtor.modelo.MBuyer;
import com.Cesde.manuelaBermudezRealtor.modelo.MProperty;
import com.Cesde.manuelaBermudezRealtor.modelo.MpropertyBuyer;
import com.Cesde.manuelaBermudezRealtor.repositories.IBuyer;
import com.Cesde.manuelaBermudezRealtor.repositories.IProperty;
import com.Cesde.manuelaBermudezRealtor.repositories.IPropertyBuyer;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class PropertyBuyerService {
    private final IPropertyBuyer repository;
    private final IProperty propertyRepository;
    private final IBuyer buyerRepository;

    public PropertyBuyerService(IPropertyBuyer repository, IProperty propertyRepository, IBuyer buyerRepository) {
        this.repository = repository;
        this.propertyRepository = propertyRepository;
        this.buyerRepository = buyerRepository;
    }
    public MpropertyBuyer crear(MpropertyBuyer relation) { return repository.save(resolverReferencias(relation)); }
    public List<MpropertyBuyer> listar() { return repository.findAll(); }
    public MpropertyBuyer buscar(Integer id) {
        return repository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Relacion comprador-propiedad no encontrada"));
    }
    public MpropertyBuyer actualizar(Integer id, MpropertyBuyer cambios) {
        MpropertyBuyer relation = buscar(id);
        relation.setPropiedad(cambios.getPropiedad());
        relation.setComprador(cambios.getComprador());
        relation.setFechaInicio(cambios.getFechaInicio());
        relation.setFechaFin(cambios.getFechaFin());
        return repository.save(resolverReferencias(relation));
    }
    public void eliminar(Integer id) { repository.delete(buscar(id)); }
    private MpropertyBuyer resolverReferencias(MpropertyBuyer relation) {
        if (relation.getPropiedad() == null || relation.getPropiedad().getIdPropiedad() == null
                || relation.getComprador() == null || relation.getComprador().getId() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Debe indicar los IDs de propiedad y comprador");
        }
        MProperty property = propertyRepository.findById(relation.getPropiedad().getIdPropiedad())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Propiedad no encontrada"));
        MBuyer buyer = buyerRepository.findById(relation.getComprador().getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Comprador no encontrado"));
        relation.setPropiedad(property);
        relation.setComprador(buyer);
        return relation;
    }
}