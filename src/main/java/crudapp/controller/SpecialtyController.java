package crudapp.controller;

import crudapp.model.Specialty;
import crudapp.repository.Database.SpecialtyHibernateIml;
import crudapp.service.GenericService;

import java.util.List;

public class SpecialtyController implements GenericController<Specialty, Integer> {
    GenericService<Specialty, Integer> specialtyService;

    public SpecialtyController(){
        specialtyService = new GenericService<>(new SpecialtyHibernateIml());
    }
    @Override
    public Specialty create(Specialty specialty) {
        specialtyService.save(specialty);
        return specialty;
    }

    @Override
    public Specialty read(Integer integer) {
        return specialtyService.getById(integer);
    }

    @Override
    public List<Specialty> readAll() {
        return specialtyService.getAll();
    }

    @Override
    public void update(Specialty specialty) {
        specialtyService.update(specialty);
    }

    @Override
    public void delete(Integer integer) {
        specialtyService.delete(integer);
    }
}
