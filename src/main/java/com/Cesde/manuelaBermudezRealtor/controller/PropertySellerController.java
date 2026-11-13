package com.Cesde.manuelaBermudezRealtor.controller;

import com.Cesde.manuelaBermudezRealtor.dto.PropertySellerDTO;
import com.Cesde.manuelaBermudezRealtor.service.PropertySellerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/property-sellers")
@CrossOrigin(origins = "*")
public class PropertySellerController {
    private final PropertySellerService service;

    public PropertySellerController(PropertySellerService service) { this.service = service; }
    @PostMapping
    public ResponseEntity<PropertySellerDTO> crear(@RequestBody PropertySellerDTO relation) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.crear(relation));
    }
    @GetMapping
    public List<PropertySellerDTO> listar() { return service.listar(); }
    @GetMapping("/{id}")
    public PropertySellerDTO buscar(@PathVariable Integer id) { return service.buscar(id); }
    @PutMapping("/{id}")
    public PropertySellerDTO actualizar(@PathVariable Integer id, @RequestBody PropertySellerDTO relation) {
        return service.actualizar(id, relation);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}