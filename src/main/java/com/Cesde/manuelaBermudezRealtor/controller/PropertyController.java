package com.Cesde.manuelaBermudezRealtor.controller;

import com.Cesde.manuelaBermudezRealtor.modelo.MProperty;
import com.Cesde.manuelaBermudezRealtor.service.PropertyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/properties")
@CrossOrigin(origins = "*")
public class PropertyController {
    private final PropertyService service;

    public PropertyController(PropertyService service) { this.service = service; }
    @PostMapping
    public ResponseEntity<MProperty> crear(@RequestBody MProperty property) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.crear(property));
    }
    @GetMapping
    public List<MProperty> listar() { return service.listar(); }
    @GetMapping("/{id}")
    public MProperty buscar(@PathVariable Integer id) { return service.buscar(id); }
    @GetMapping("/barrio/{barrio}")
    public List<MProperty> porBarrio(@PathVariable String barrio) { return service.buscarPorBarrio(barrio); }
    @GetMapping("/estrato/{estrato}")
    public List<MProperty> porEstrato(@PathVariable int estrato) { return service.buscarPorEstrato(estrato); }
    @GetMapping("/municipio/{municipio}")
    public List<MProperty> porMunicipio(@PathVariable String municipio) { return service.buscarPorMunicipio(municipio); }
    @GetMapping("/valor")
    public List<MProperty> porRango(@RequestParam float min, @RequestParam float max) {
        return service.buscarPorRango(min, max);
    }
    @PutMapping("/{id}")
    public MProperty actualizar(@PathVariable Integer id, @RequestBody MProperty property) {
        return service.actualizar(id, property);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}