package com.Cesde.manuelaBermudezRealtor.service;

import com.Cesde.manuelaBermudezRealtor.dto.ContractDTO;
import com.Cesde.manuelaBermudezRealtor.modelo.MBuyer;
import com.Cesde.manuelaBermudezRealtor.modelo.MContract;
import com.Cesde.manuelaBermudezRealtor.modelo.MProperty;
import com.Cesde.manuelaBermudezRealtor.modelo.MSeller;
import com.Cesde.manuelaBermudezRealtor.repositories.IBuyer;
import com.Cesde.manuelaBermudezRealtor.repositories.IContract;
import com.Cesde.manuelaBermudezRealtor.repositories.IProperty;
import com.Cesde.manuelaBermudezRealtor.repositories.ISeller;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ContractService {
    private final IContract repository;
    private final IProperty propertyRepository;
    private final ISeller sellerRepository;
    private final IBuyer buyerRepository;

    public ContractService(IContract repository, IProperty propertyRepository, ISeller sellerRepository, IBuyer buyerRepository) {
        this.repository = repository;
        this.propertyRepository = propertyRepository;
        this.sellerRepository = sellerRepository;
        this.buyerRepository = buyerRepository;
    }
    public ContractDTO crear(ContractDTO dto) { return convertir(repository.save(resolverReferencias(convertir(dto)))); }
    public List<ContractDTO> listar() { return repository.findAll().stream().map(this::convertir).toList(); }
    public ContractDTO buscar(Integer id) { return convertir(buscarEntidad(id)); }
    public ContractDTO actualizar(Integer id, ContractDTO cambios) {
        MContract contract = buscarEntidad(id);
        contract.setPropiedad(propertyRepository.getReferenceById(cambios.getPropiedadId()));
        contract.setVendedor(sellerRepository.getReferenceById(cambios.getVendedorId()));
        contract.setComprador(buyerRepository.getReferenceById(cambios.getCompradorId()));
        contract.setFechaContrato(cambios.getFechaContrato());
        contract.setValorVenta(cambios.getValorVenta());
        contract.setEstado(cambios.getEstado());
        return convertir(repository.save(resolverReferencias(contract)));
    }
    public void eliminar(Integer id) { repository.delete(buscarEntidad(id)); }
    private MContract buscarEntidad(Integer id) {
        return repository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Contrato no encontrado"));
    }
    private MContract convertir(ContractDTO dto) {
        MContract contract = new MContract();
        contract.setPropiedad(propertyRepository.getReferenceById(dto.getPropiedadId()));
        contract.setVendedor(sellerRepository.getReferenceById(dto.getVendedorId()));
        contract.setComprador(buyerRepository.getReferenceById(dto.getCompradorId()));
        contract.setFechaContrato(dto.getFechaContrato());
        contract.setValorVenta(dto.getValorVenta());
        contract.setEstado(dto.getEstado());
        return contract;
    }
    private ContractDTO convertir(MContract contract) {
        ContractDTO dto = new ContractDTO();
        dto.setId(contract.getId());
        dto.setPropiedadId(contract.getPropiedad().getIdPropiedad());
        dto.setVendedorId(contract.getVendedor().getId());
        dto.setCompradorId(contract.getComprador().getId());
        dto.setFechaContrato(contract.getFechaContrato());
        dto.setValorVenta(contract.getValorVenta());
        dto.setEstado(contract.getEstado());
        return dto;
    }
    private MContract resolverReferencias(MContract contract) {
        if (contract.getPropiedad() == null || contract.getVendedor() == null || contract.getComprador() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Debe indicar los IDs de propiedad, vendedor y comprador");
        }
        MProperty property = propertyRepository.findById(contract.getPropiedad().getIdPropiedad())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Propiedad no encontrada"));
        MSeller seller = sellerRepository.findById(contract.getVendedor().getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Vendedor no encontrado"));
        MBuyer buyer = buyerRepository.findById(contract.getComprador().getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Comprador no encontrado"));
        contract.setPropiedad(property);
        contract.setVendedor(seller);
        contract.setComprador(buyer);
        return contract;
    }
}