package com.Cesde.manuelaBermudezRealtor.controller;

import com.Cesde.manuelaBermudezRealtor.modelo.MUser;
import com.Cesde.manuelaBermudezRealtor.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {
    private final UserService service;

    public UserController(UserService service) { this.service = service; }
    @PostMapping
    public ResponseEntity<MUser> crear(@RequestBody MUser user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.crear(user));
    }
    @GetMapping
    public List<MUser> listar() { return service.listar(); }
    @GetMapping("/{id}")
    public MUser buscar(@PathVariable Integer id) { return service.buscar(id); }
    @PutMapping("/{id}")
    public MUser actualizar(@PathVariable Integer id, @RequestBody MUser user) { return service.actualizar(id, user); }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}