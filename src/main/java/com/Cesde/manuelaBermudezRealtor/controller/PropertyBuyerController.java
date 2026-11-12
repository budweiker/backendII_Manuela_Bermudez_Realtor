package com.Cesde.manuelaBermudezRealtor.controller;

import com.Cesde.manuelaBermudezRealtor.modelo.MpropertyBuyer;
import com.Cesde.manuelaBermudezRealtor.service.PropertyBuyerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/property-buyers")
@CrossOrigin(origins = "*")
public class PropertyBuyerController {
    private final PropertyBuyerService service;

    public PropertyBuyerController(PropertyBuyerService service) { this.service = service; }
    @PostMapping
    public ResponseEntity<MpropertyBuyer> crear(@RequestBody MpropertyBuyer relation) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.crear(relation));
    }
    @GetMapping
    public List<MpropertyBuyer> listar() { return service.listar(); }
    @GetMapping("/{id}")
    public MpropertyBuyer buscar(@PathVariable Integer id) { return service.buscar(id); }
    @PutMapping("/{id}")
    public MpropertyBuyer actualizar(@PathVariable Integer id, @RequestBody MpropertyBuyer relation) {
        return service.actualizar(id, relation);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}