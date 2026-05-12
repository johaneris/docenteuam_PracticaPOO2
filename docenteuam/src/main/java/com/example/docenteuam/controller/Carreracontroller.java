package com.example.docenteuam.controller;

import com.example.docenteuam.models.Carrera;
import com.example.docenteuam.service.CarreraServicio;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carreras")
public class Carreracontroller {

    private final CarreraServicio service;

    public Carreracontroller(CarreraServicio service) {
        this.service = service;
    }

    @GetMapping
    public List<Carrera> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Carrera> findById(@PathVariable Long id) {
        Carrera carrera = service.findById(id);

        if (carrera == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(carrera);
    }

    @PostMapping
    public Carrera save(@RequestBody Carrera carrera) {
        return service.save(carrera);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Carrera> update(@PathVariable Long id, @RequestBody Carrera carrera) {
        Carrera carreraExistente = service.findById(id);

        if (carreraExistente == null) {
            return ResponseEntity.notFound().build();
        }

        carrera.setId(id);
        Carrera carreraActualizada = service.save(carrera);

        return ResponseEntity.ok(carreraActualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        Carrera carreraExistente = service.findById(id);

        if (carreraExistente == null) {
            return ResponseEntity.notFound().build();
        }

        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}