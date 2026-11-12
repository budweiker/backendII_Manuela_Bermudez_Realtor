package com.Cesde.manuelaBermudezRealtor.controller;

import com.Cesde.manuelaBermudezRealtor.modelo.MSeller;
import com.Cesde.manuelaBermudezRealtor.service.SellerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sellers")
@CrossOrigin(origins = "*")
public class SellerController {
    private final SellerService service;

    public SellerController(SellerService service) { this.service = service; }
    @PostMapping
    public ResponseEntity<MSeller> crear(@RequestBody MSeller seller) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.crearVendedor(seller));
    }
    @GetMapping
    public List<MSeller> listar() { return service.listarVendedores(); }
    @GetMapping("/{id}")
    public MSeller buscar(@PathVariable Integer id) { return service.buscarVendedorPorId(id); }
    @PutMapping("/{id}")
    public MSeller actualizar(@PathVariable Integer id, @RequestBody MSeller seller) {
        return service.actualizarVendedor(id, seller);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        service.eliminarVendedor(id);
        return ResponseEntity.noContent().build();
    }
}