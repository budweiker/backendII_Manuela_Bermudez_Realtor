package com.Cesde.manuelaBermudezRealtor.service;

import com.Cesde.manuelaBermudezRealtor.dto.PropertyBuyerDTO;
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

	public PropertyBuyerDTO crear(PropertyBuyerDTO dto) {
		return convertir(repository.save(resolverReferencias(convertir(dto))));
	}

	public List<PropertyBuyerDTO> listar() {
		return repository.findAll().stream().map(this::convertir).toList();
	}

	public PropertyBuyerDTO buscar(Integer id) {
		return convertir(buscarEntidad(id));
	}

	public PropertyBuyerDTO actualizar(Integer id, PropertyBuyerDTO cambios) {
		MpropertyBuyer relation = buscarEntidad(id);
		relation.setPropiedad(propertyRepository.getReferenceById(cambios.getPropiedadId()));
		relation.setComprador(buyerRepository.getReferenceById(cambios.getCompradorId()));
		relation.setFechaInicio(cambios.getFechaInicio());
		relation.setFechaFin(cambios.getFechaFin());
		return convertir(repository.save(resolverReferencias(relation)));
	}

	public void eliminar(Integer id) {
		repository.delete(buscarEntidad(id));
	}

	private MpropertyBuyer buscarEntidad(Integer id) {
		return repository.findById(id).orElseThrow(() ->
				new ResponseStatusException(HttpStatus.NOT_FOUND, "Relacion comprador-propiedad no encontrada"));
	}

	private MpropertyBuyer convertir(PropertyBuyerDTO dto) {
		if (dto == null || dto.getPropiedadId() == null || dto.getCompradorId() == null) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Debe indicar los IDs de propiedad y comprador");
		}
		MpropertyBuyer relation = new MpropertyBuyer();
		relation.setPropiedad(propertyRepository.getReferenceById(dto.getPropiedadId()));
		relation.setComprador(buyerRepository.getReferenceById(dto.getCompradorId()));
		relation.setFechaInicio(dto.getFechaInicio());
		relation.setFechaFin(dto.getFechaFin());
		return relation;
	}

	private PropertyBuyerDTO convertir(MpropertyBuyer relation) {
		PropertyBuyerDTO dto = new PropertyBuyerDTO();
		dto.setId(relation.getId());
		dto.setPropiedadId(relation.getPropiedad().getIdPropiedad());
		dto.setCompradorId(relation.getComprador().getId());
		dto.setFechaInicio(relation.getFechaInicio());
		dto.setFechaFin(relation.getFechaFin());
		return dto;
	}

	private MpropertyBuyer resolverReferencias(MpropertyBuyer relation) {
		if (relation.getPropiedad() == null || relation.getComprador() == null) {
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