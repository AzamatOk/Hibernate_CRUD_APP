package crudapp.view;

import crudapp.controller.DeveloperController;
import crudapp.controller.SkillController;
import crudapp.controller.SpecialtyController;
import crudapp.model.Developer;

import java.util.HashSet;
import java.util.Scanner;

public class DeveloperView {
    Scanner scanner;
    private DeveloperController developerController = new DeveloperController();
    private SkillController skillController = new SkillController();
    private SpecialtyController specialtyController = new SpecialtyController();

    public void workProgram(){
        while (true){
            getAllDeveloper();
            writeNewDeveloper();
            updateDeveloper();
            deleteDeveloper();
            getAllDeveloper();
            break;
        }
    }
    public void writeNewDeveloper(){
        scanner = new Scanner(System.in);
        HashSet skills = new HashSet();



        System.out.println("Введите firstName для Developer");
        String firstNameDeveloper = scanner.nextLine();

        System.out.println("Введите lastName для Developer");
        String lastNameDeveloper = scanner.nextLine();

        System.out.println(skillController.readAll());
        do {
            System.out.println("Введите id Skill для Developer");
            Integer idSkill = scanner.nextInt();
            skills.add(skillController.read(idSkill));
            System.out.println("Хотите добавить еще? yes/no");
            String answer = scanner.next();
            if (answer.equals("no")){
                break;
            }
            System.out.println();
        }while (true);

        System.out.println(specialtyController.readAll());
        System.out.println("Введите id Specialty для Developer");
        Integer idSpecialty = scanner.nextInt();


        Developer developerToSave = new Developer(firstNameDeveloper, lastNameDeveloper,skills,specialtyController.read(idSpecialty));
        developerController.create(developerToSave);
    }

    public void updateDeveloper(){
        scanner = new Scanner(System.in);
        Developer developerToSave = new Developer();


        System.out.println("Введите id Developer для обновления ");
        Integer id = scanner.nextInt();
        developerToSave = developerController.read(id);

        System.out.println("Введите новое firstName Developer");
        String firstNameDeveloper = scanner.nextLine();
        developerToSave.setFirstName(firstNameDeveloper);

        System.out.println("Введите новое lastName Developer");
        String lastNameDeveloper = scanner.nextLine();
        developerToSave.setLastName(lastNameDeveloper);

        System.out.println(specialtyController.readAll());
        System.out.println("Введите id нового Specialty для Developer");
        Integer idSpecialty = scanner.nextInt();
        developerToSave.setSpecialty(specialtyController.read(idSpecialty));

        developerController.update(developerToSave);
    }

    public void deleteDeveloper(){
        scanner = new Scanner(System.in);
        System.out.println("Введите id Developer для удаления");
        Integer id = scanner.nextInt();

        developerController.delete(id);
    }

    public void getAllDeveloper(){
        System.out.println(developerController.readAll());
    }

    public void findDeveloperById() {
    }
}
