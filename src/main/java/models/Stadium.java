package models;

import javax.persistence.*;

@Entity
@Table(name="stadiums")
public class Stadium {

    private int id;
    private Team team;
    private String location;

    public Stadium() {
    }

    public Stadium(Team team, String location) {
        this.team = team;
        this.location = location;
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

    @OneToOne(cascade = CascadeType.PERSIST)
    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    @Column(name="location")
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
