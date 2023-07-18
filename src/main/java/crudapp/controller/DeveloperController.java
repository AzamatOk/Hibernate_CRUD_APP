package crudapp.controller;

import crudapp.model.Developer;
import crudapp.repository.Database.DeveloperHibernateIml;
import crudapp.service.GenericService;

import java.util.List;

public class DeveloperController implements GenericController<Developer, Integer> {

    GenericService<Developer, Integer> developerService;

    public DeveloperController(){
        developerService = new GenericService<>(new DeveloperHibernateIml());
    }
    @Override
    public Developer create(Developer developer) {
        developerService.save(developer);
        return developer;
    }

    @Override
    public Developer read(Integer integer) {
        return developerService.getById(integer);
    }

    @Override
    public List<Developer> readAll() {
        return developerService.getAll();
    }

    @Override
    public void update(Developer developer) {
        developerService.update(developer);
    }

    @Override
    public void delete(Integer integer) {
        developerService.delete(integer);
    }


}