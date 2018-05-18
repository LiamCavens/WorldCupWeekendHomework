package models;

import javax.persistence.*;

@Entity
@Table(name="managers")
public class Manager {

    private int id;
    private String name;
    private int salary;
    private Team team;

    public Manager() {
    }

    public Manager(String name, int salary, Team team) {
        this.name = name;
        this.salary = salary;
        this.team = team;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name="name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name="salary")
    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @OneToOne(cascade = CascadeType.PERSIST)
    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
