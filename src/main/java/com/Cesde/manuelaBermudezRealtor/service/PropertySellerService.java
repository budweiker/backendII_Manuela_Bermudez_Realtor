package com.Cesde.manuelaBermudezRealtor.service;

import com.Cesde.manuelaBermudezRealtor.modelo.MProperty;
import com.Cesde.manuelaBermudezRealtor.modelo.MPropertySeller;
import com.Cesde.manuelaBermudezRealtor.modelo.MSeller;
import com.Cesde.manuelaBermudezRealtor.repositories.IProperty;
import com.Cesde.manuelaBermudezRealtor.repositories.IPropertySeller;
import com.Cesde.manuelaBermudezRealtor.repositories.ISeller;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class PropertySellerService {
    private final IPropertySeller repository;
    private final IProperty propertyRepository;
    private final ISeller sellerRepository;

    public PropertySellerService(IPropertySeller repository, IProperty propertyRepository, ISeller sellerRepository) {
        this.repository = repository;
        this.propertyRepository = propertyRepository;
        this.sellerRepository = sellerRepository;
    }
    public MPropertySeller crear(MPropertySeller relation) { return repository.save(resolverReferencias(relation)); }
    public List<MPropertySeller> listar() { return repository.findAll(); }
    public MPropertySeller buscar(Integer id) {
        return repository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Relacion vendedor-propiedad no encontrada"));
    }
    public MPropertySeller actualizar(Integer id, MPropertySeller cambios) {
        MPropertySeller relation = buscar(id);
        relation.setPropiedad(cambios.getPropiedad());
        relation.setVendedor(cambios.getVendedor());
        relation.setFechaInicio(cambios.getFechaInicio());
        relation.setFechaFin(cambios.getFechaFin());
        return repository.save(resolverReferencias(relation));
    }
    public void eliminar(Integer id) { repository.delete(buscar(id)); }
    private MPropertySeller resolverReferencias(MPropertySeller relation) {
        if (relation.getPropiedad() == null || relation.getPropiedad().getIdPropiedad() == null
                || relation.getVendedor() == null || relation.getVendedor().getId() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Debe indicar los IDs de propiedad y vendedor");
        }
        MProperty property = propertyRepository.findById(relation.getPropiedad().getIdPropiedad())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Propiedad no encontrada"));
        MSeller seller = sellerRepository.findById(relation.getVendedor().getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Vendedor no encontrado"));
        relation.setPropiedad(property);
        relation.setVendedor(seller);
        return relation;
    }
}