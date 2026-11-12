package com.Cesde.manuelaBermudezRealtor.controller;

import com.Cesde.manuelaBermudezRealtor.modelo.MAdmin;
import com.Cesde.manuelaBermudezRealtor.service.AdminService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admins")
@CrossOrigin(origins = "*")
public class AdminController {
    private final AdminService service;

    public AdminController(AdminService service) { this.service = service; }
    @PostMapping
    public ResponseEntity<MAdmin> crear(@RequestBody MAdmin admin) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.crear(admin));
    }
    @GetMapping
    public List<MAdmin> listar() { return service.listar(); }
    @GetMapping("/{id}")
    public MAdmin buscar(@PathVariable Integer id) { return service.buscar(id); }
    @PutMapping("/{id}")
    public MAdmin actualizar(@PathVariable Integer id, @RequestBody MAdmin admin) { return service.actualizar(id, admin); }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}