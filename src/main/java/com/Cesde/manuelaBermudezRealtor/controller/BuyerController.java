package com.Cesde.manuelaBermudezRealtor.controller;

import com.Cesde.manuelaBermudezRealtor.modelo.MBuyer;
import com.Cesde.manuelaBermudezRealtor.service.BuyerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/buyers")
@CrossOrigin(origins = "*")
public class BuyerController {
    private final BuyerService service;

    public BuyerController(BuyerService service) { this.service = service; }
    @PostMapping
    public ResponseEntity<MBuyer> crear(@RequestBody MBuyer buyer) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.crear(buyer));
    }
    @GetMapping
    public List<MBuyer> listar() { return service.listar(); }
    @GetMapping("/{id}")
    public MBuyer buscar(@PathVariable Integer id) { return service.buscar(id); }
    @PutMapping("/{id}")
    public MBuyer actualizar(@PathVariable Integer id, @RequestBody MBuyer buyer) { return service.actualizar(id, buyer); }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}