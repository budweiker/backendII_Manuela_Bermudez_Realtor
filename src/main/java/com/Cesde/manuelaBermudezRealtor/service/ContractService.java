package com.Cesde.manuelaBermudezRealtor.service;

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
    public MContract crear(MContract contract) { return repository.save(resolverReferencias(contract)); }
    public List<MContract> listar() { return repository.findAll(); }
    public MContract buscar(Integer id) {
        return repository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Contrato no encontrado"));
    }
    public MContract actualizar(Integer id, MContract cambios) {
        MContract contract = buscar(id);
        contract.setPropiedad(cambios.getPropiedad());
        contract.setVendedor(cambios.getVendedor());
        contract.setComprador(cambios.getComprador());
        contract.setFechaContrato(cambios.getFechaContrato());
        contract.setValorVenta(cambios.getValorVenta());
        contract.setEstado(cambios.getEstado());
        return repository.save(resolverReferencias(contract));
    }
    public void eliminar(Integer id) { repository.delete(buscar(id)); }
    private MContract resolverReferencias(MContract contract) {
        if (contract.getPropiedad() == null || contract.getPropiedad().getIdPropiedad() == null
                || contract.getVendedor() == null || contract.getVendedor().getId() == null
                || contract.getComprador() == null || contract.getComprador().getId() == null) {
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