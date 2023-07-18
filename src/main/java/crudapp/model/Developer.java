package crudapp.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "SKILLS")
public class Developer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "id")
    private int id;

    @Column(name = "FIRSTNAME")
    private String firstName;
    @Column(name = "LASTNAME")
    private String lastName;
    @ManyToMany
    private Set skillList;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Specialty specialty;
    @Column(name = "STATUS")
    @Enumerated(EnumType.ORDINAL)
    private Status status;
    public Developer() {
    }

    public Developer(String firstName, String lastName,Set skillList, Specialty specialty) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.status = Status.ACTIVE;
        this.skillList = skillList;
        this.specialty = specialty;
    }

    public Set getSkillList() {
        return skillList;
    }

    public void setSkillList(Set skillList) {
        this.skillList = skillList;
    }

    public Specialty getSpecialty() {
        return specialty;
    }

    public void setSpecialty(Specialty specialty) {
        this.specialty = specialty;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    @Override
    public String toString() {
        return "Developer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", skillList=" + skillList +
                ", specialty=" + specialty +
                ", status=" + status +
                '}';
    }
}
