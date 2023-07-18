package crudapp.view;

import crudapp.controller.SkillController;
import crudapp.model.Skill;

import java.util.Scanner;

public class SkillView {
    Scanner scanner;
    private SkillController skillController = new SkillController();

    public void workProgram(){
        while (true){
            getAllSkill();
            writeNewSkill();
            updateSkill();
            deleteSkill();
            getAllSkill();
            break;
        }
    }
    public void writeNewSkill(){
        scanner = new Scanner(System.in);

        System.out.println("Введите название Skill");
        String nameSkill = scanner.next();


        Skill skillToSave = new Skill(nameSkill);

        skillController.create(skillToSave);
    }

    public void updateSkill(){
        scanner = new Scanner(System.in);
        Skill skillToSave = new Skill();

        System.out.println("Введите id Skill для обновления ");
        Integer id = scanner.nextInt();
        skillToSave = skillController.read(id);

        System.out.println("Введите новое название Skill");
        String nameSkill = scanner.next();
        skillToSave.setName(nameSkill);


        skillController.update(skillToSave);
    }

    public void deleteSkill(){
        scanner = new Scanner(System.in);

        System.out.println("Введите id Skill для удаления");
        Integer id = scanner.nextInt();

        skillController.delete(id);
    }

    public void getAllSkill(){
        System.out.println(skillController.readAll());
    }

    public void findSkillById() {
    }
}
