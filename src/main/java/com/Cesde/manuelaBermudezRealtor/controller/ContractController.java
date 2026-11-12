package com.Cesde.manuelaBermudezRealtor.controller;

import com.Cesde.manuelaBermudezRealtor.modelo.MContract;
import com.Cesde.manuelaBermudezRealtor.service.ContractService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contracts")
@CrossOrigin(origins = "*")
public class ContractController {
    private final ContractService service;

    public ContractController(ContractService service) { this.service = service; }
    @PostMapping
    public ResponseEntity<MContract> crear(@RequestBody MContract contract) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.crear(contract));
    }
    @GetMapping
    public List<MContract> listar() { return service.listar(); }
    @GetMapping("/{id}")
    public MContract buscar(@PathVariable Integer id) { return service.buscar(id); }
    @PutMapping("/{id}")
    public MContract actualizar(@PathVariable Integer id, @RequestBody MContract contract) {
        return service.actualizar(id, contract);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}