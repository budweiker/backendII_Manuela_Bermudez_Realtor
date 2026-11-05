
package com.Cesde.manuelaBermudezRealtor.service;

import com.Cesde.manuelaBermudezRealtor.modelo.MSeller;
import com.Cesde.manuelaBermudezRealtor.repositories.SellerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellerService {

    private final SellerRepository sellerRepository;

    public SellerService(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    public MSeller crearVendedor(MSeller vendedor) {
        return sellerRepository.save(vendedor);
    }

    public List<MSeller> listarVendedores() {
        return sellerRepository.findAll();
    }

    public MSeller buscarVendedorPorId(Integer id) {
        return sellerRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "El vendedor con id " + id + " no existe"
                        ));
    }

    public MSeller actualizarVendedor(Integer id, MSeller actualizado) {
        MSeller vendedor = buscarVendedorPorId(id);

        vendedor.setNombre(actualizado.getNombre());
        vendedor.setPassword(actualizado.getPassword());
        vendedor.setTelefono(actualizado.getTelefono());
        vendedor.setCorreo(actualizado.getCorreo());
        vendedor.setStatus(actualizado.isStatus());
        vendedor.setPropiedadesVendidas(actualizado.getPropiedadesVendidas());
        vendedor.setBalance(actualizado.getBalance());

        return sellerRepository.save(vendedor);
    }

    public void eliminarVendedor(Integer id) {
        sellerRepository.delete(buscarVendedorPorId(id));
    }
}
