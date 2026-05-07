package com.example.docenteuam.repository;

import com.example.docenteuam.models.Carrera;

import java.util.List;

public class CarreraServicio {

    private final CarreraRepository repo;
    public CarreraServicio(CarreraRepository repo) {
        this.repo = repo;
    }

    public List<Carrera> findAll() {
        return repo.findAll();
    }

    public Carrera findById(long id) {
        return repo.findById(id).orElse(null);
    }

    public Carrera save(Carrera carrera) {
        return repo.save(carrera);
    }

    public void deleteById(long id) {
        repo.deleteById(id);
    }

}