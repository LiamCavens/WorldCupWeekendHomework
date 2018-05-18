package models;

import javax.persistence.*;

@Entity
@Table(name="stadiums")
public class Stadium {

    private int id;
    private String location;

    public Stadium() {
    }

    public Stadium(String location) {
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

    @Column(name="location")
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
