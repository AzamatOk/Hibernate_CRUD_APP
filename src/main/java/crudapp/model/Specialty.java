package crudapp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "SPECIALTIES")
public class Specialty {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "NAME")
    private String Name;
    @Column(name = "STATUS")
    @Enumerated(EnumType.ORDINAL)
    private Status status;

    public Specialty() {
    }

    public Specialty( String name) {
        Name = name;
        this.status = Status.ACTIVE;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Specialty{" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                ", status=" + status +
                '}';
    }
}
