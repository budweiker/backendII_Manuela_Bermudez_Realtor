package com.Cesde.manuelaBermudezRealtor.service;

import com.Cesde.manuelaBermudezRealtor.dto.PropertySellerDTO;
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
    public PropertySellerDTO crear(PropertySellerDTO dto) {
        return convertir(repository.save(resolverReferencias(convertir(dto))));
    }
    public List<PropertySellerDTO> listar() { return repository.findAll().stream().map(this::convertir).toList(); }
    public PropertySellerDTO buscar(Integer id) { return convertir(buscarEntidad(id)); }
    public PropertySellerDTO actualizar(Integer id, PropertySellerDTO cambios) {
        MPropertySeller relation = buscarEntidad(id);
        relation.setPropiedad(propertyRepository.getReferenceById(cambios.getPropiedadId()));
        relation.setVendedor(sellerRepository.getReferenceById(cambios.getVendedorId()));
        relation.setFechaInicio(cambios.getFechaInicio());
        relation.setFechaFin(cambios.getFechaFin());
        return convertir(repository.save(resolverReferencias(relation)));
    }
    public void eliminar(Integer id) { repository.delete(buscarEntidad(id)); }
    private MPropertySeller buscarEntidad(Integer id) {
        return repository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Relacion vendedor-propiedad no encontrada"));
    }
    private MPropertySeller convertir(PropertySellerDTO dto) {
        MPropertySeller relation = new MPropertySeller();
        relation.setPropiedad(propertyRepository.getReferenceById(dto.getPropiedadId()));
        relation.setVendedor(sellerRepository.getReferenceById(dto.getVendedorId()));
        relation.setFechaInicio(dto.getFechaInicio());
        relation.setFechaFin(dto.getFechaFin());
        return relation;
    }
    private PropertySellerDTO convertir(MPropertySeller relation) {
        PropertySellerDTO dto = new PropertySellerDTO();
        dto.setId(relation.getId());
        dto.setPropiedadId(relation.getPropiedad().getIdPropiedad());
        dto.setVendedorId(relation.getVendedor().getId());
        dto.setFechaInicio(relation.getFechaInicio());
        dto.setFechaFin(relation.getFechaFin());
        return dto;
    }
    private MPropertySeller resolverReferencias(MPropertySeller relation) {
        if (relation.getPropiedad() == null || relation.getVendedor() == null) {
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