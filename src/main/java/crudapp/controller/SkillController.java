package crudapp.controller;

import crudapp.model.Skill;
import crudapp.repository.Database.SkillHibernateIml;
import crudapp.service.GenericService;

import java.util.List;

public class SkillController implements GenericController<Skill, Integer>{
    GenericService<Skill, Integer> skillService;

    public SkillController(){
        skillService = new GenericService<>(new SkillHibernateIml());
    }
    @Override
    public Skill create(Skill skill) {
        skillService.save(skill);
        return skill;
    }

    @Override
    public Skill read(Integer integer) {
        return skillService.getById(integer);
    }

    @Override
    public List<Skill> readAll() {
        return skillService.getAll();
    }

    @Override
    public void update(Skill skill) {
        skillService.update(skill);
    }

    @Override
    public void delete(Integer integer) {
        skillService.delete(integer);
    }
}