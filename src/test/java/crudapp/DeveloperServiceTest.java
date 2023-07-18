package crudapp;

import crudapp.model.Developer;
import crudapp.model.Skill;
import crudapp.model.Specialty;
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
import java.util.HashSet;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class DeveloperServiceTest extends TestCase {
    @InjectMocks
    GenericService<Developer, Integer> service;
    HashSet skillList = new HashSet<>();
    Specialty specialty = new Specialty();

    @Mock
    GenericRepository repository;

    public DeveloperServiceTest(){
        skillList.add(new Skill("Python"));
        skillList.add(new Skill("Java"));

        specialty = new Specialty("Engineer");
    }
    @Before
    public void setUp(){
        service = new GenericService<>(repository);
    }

    @Test
    public void testGetAllDevelopers() {
        List<Developer> developerList = new ArrayList<>(List.of(
                new Developer( "Geor", "Huga", skillList, specialty),
                new Developer( "Eugene", "Suleimanov", skillList, specialty)
        ));

        Mockito.when(repository.getAll()).thenReturn(developerList);

        assertEquals(developerList, service.getAll());
        Mockito.verify(repository).getAll();
    }

    @Test(expected = RuntimeException.class)
    public void testThrowRuntimeExceptionWhenGetAllDevelopers() {
        Mockito.when(repository.getAll()).thenThrow(RuntimeException.class);

        repository.getAll();
    }

    @Test
    public void testGetDeveloperById() {
        Developer developer = new Developer( "Geor", "Hugaev", skillList, specialty);

        Mockito.when(repository.getById(1)).thenReturn(developer);

        assertEquals(developer, service.getById(1));
        Mockito.verify(repository).getById(1);
    }

    @Test(expected = RuntimeException.class)
    public void testThrowRuntimeExceptionWhenGetWrongDeveloperById() {
        Mockito.when(repository.getById(100)).thenThrow(RuntimeException.class);

        repository.getById(100);
    }

    @Test
    public void testSaveDeveloper() {
        Developer developerToSave = new Developer( "Geor", "Huga",skillList, specialty);

        Mockito.when(repository.save(developerToSave)).thenReturn(developerToSave);

        assertEquals(developerToSave, service.save(developerToSave));
        Mockito.verify(repository).save(developerToSave);
    }

    @Test(expected = RuntimeException.class)
    public void testThrowRuntimeExceptionWhenSaveDeveloper() {
        Developer developerToSave = new Developer( "geor", "Huga",  skillList, specialty);

        Mockito.when(repository.save(developerToSave)).thenThrow(RuntimeException.class);

        service.save(developerToSave);
    }

    @Test
    public void testUpdateDeveloper() {
        Developer developerToUpdate = new Developer( "Geor", "Huga", skillList, specialty);

        Mockito.when(repository.update(developerToUpdate)).thenReturn(developerToUpdate);

        assertEquals(developerToUpdate, service.update(developerToUpdate));
        Mockito.verify(repository).update(developerToUpdate);
    }

    @Test(expected = RuntimeException.class)
    public void testThrowRuntimeExceptionWhenUpdateDeveloper() {
        Developer developerToUpdate = new Developer( "Geor", "Huga", skillList, specialty);

        Mockito.when(repository.update(developerToUpdate)).thenThrow(RuntimeException.class);

        service.update(developerToUpdate);
    }

    @Test
    public void testDeleteDeveloper() {
        Mockito.doNothing().when(repository).deleteById(1);

        service.delete(1);

        Mockito.verify(repository).deleteById(1);
    }

    @Test(expected = RuntimeException.class)
    public void testDeleteWrongDeveloper() {
        Mockito.doThrow(RuntimeException.class).when(repository).deleteById(1);

        service.delete(1);
    }
}
