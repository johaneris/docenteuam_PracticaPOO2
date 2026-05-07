package com.example.docenteuam.controller;


import com.example.docenteuam.models.Carrera;
import com.example.docenteuam.repository.CarreraServicio;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/carreras")
public class Ciudadcontroller {

    private final CarreraServicio service;

    public Ciudadcontroller(CarreraServicio service) {
        this.service = service;
    }

    @GetMapping
    public List<Carrera> findAll() {
        return service.findAll();
    }

    @GetMapping
    public Carrera findById(long id) {
        return service.findById(id);
    }


    @PostMapping
    public Carrera save(Carrera carrera) {
        return service.save(carrera);
    }

    @PutMapping("/{id}")
    public Carrera update(Carrera carrera) {
        int id = 0;
        carrera.setId(id);
        return service.save(carrera);
    }

    @DeleteMapping
    public void deleteById(long id) {
        service.deleteById(id);
    }

}
