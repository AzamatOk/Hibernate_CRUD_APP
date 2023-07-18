package crudapp.view;

import crudapp.controller.SkillController;
import crudapp.controller.SpecialtyController;
import crudapp.model.Skill;
import crudapp.model.Specialty;

import java.util.Scanner;

public class SpecialtyView {
    Scanner scanner;
    private SpecialtyController specialtyController = new SpecialtyController();


    public void workProgram(){
        while (true){
            getAllSpeciality();
            writeNewSpecialty();
            updateSpecialty();
            deleteSpecialty();
            getAllSpeciality();
            break;
        }
    }
    public void writeNewSpecialty(){
        scanner = new Scanner(System.in);

        System.out.println("Введите название Specialty");
        String nameSpecialty = scanner.next();

        Specialty specialtyToSave = new Specialty(nameSpecialty);

        specialtyController.create(specialtyToSave);

    }

    public void updateSpecialty(){
        scanner = new Scanner(System.in);

        System.out.println("Введите id Specialty для обновления ");
        Integer id = scanner.nextInt();
        Specialty specialty = specialtyController.read(id);

        System.out.println("Введите новое название Specialty");
        String nameSpecialty = scanner.next();
        specialty.setName(nameSpecialty);

        specialtyController.update(specialty);
    }

    public void deleteSpecialty(){
        scanner = new Scanner(System.in);
        System.out.println("Введите id Specialty для удаления");
        Integer id = scanner.nextInt();

        specialtyController.delete(id);
    }

    public void getAllSpeciality(){
        System.out.println(specialtyController.readAll());
    }

    public void findSpecialtyById() {
    }
}
