package crudapp.model;

import jakarta.persistence.*;


@Entity
@Table(name = "SKILLS")
public class Skill {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column (name = "id")
    private int id;
    @Column(name = "NAME")
    private String Name;

    @Column(name = "STATUS")
    @Enumerated(EnumType.ORDINAL)
    private Status status;

    public Skill() {
    }

    public Skill(String name) {
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

    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (!this.getClass().equals(object.getClass())) {
            return false;
        }

        Skill object2 = (Skill) object;
        if ((this.id == object2.getId()) && (this.Name == object2.getName()) ) {
            return true;
        }
        return false;
    }

    public int hasCode() {
        int code = 0;
        code = (id + Name ).hashCode();
        return code;
    }

    @Override
    public String toString() {
        return "Skill{" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                ", status=" + status +
                '}';
    }
}
