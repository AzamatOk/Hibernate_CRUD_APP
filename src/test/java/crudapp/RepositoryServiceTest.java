package crudapp;


import crudapp.model.Skill;
import crudapp.repository.GenericRepository;
import crudapp.service.GenericService;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class RepositoryServiceTest extends TestCase {
    @InjectMocks
    GenericService<Skill, Integer> service;

    @Mock
    GenericRepository repository;

    @Before
    public void setUp(){
        service = new GenericService<>(repository);
    }

    @Test
    public void getAllSkillTest(){
        List<Skill> skills = new ArrayList<>(List.of(
                new Skill( "Python"),
                new Skill("Java")
        ));

        Mockito.when(repository.getAll()).thenReturn(skills);
        assertEquals(skills,service.getAll());
        Mockito.verify(repository).getAll();
    }

    @Test(expected = Exception.class)
    public void whenSkillAnnotation(){
        Mockito.when(repository.getAll()).thenThrow(IllegalStateException.class);
        repository.getAll();
    }


    @Test
    public void getByIdTest(){
        Skill skill = new Skill("Java");

        Mockito.when(repository.getById(1)).thenReturn(skill);
        assertEquals(skill, service.getById(1));
        Mockito.verify(repository).getById(1);
    }
}
