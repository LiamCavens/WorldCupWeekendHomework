package models;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="competitions")
public abstract class Competition {

    private int id;
    private String name;
    private Set<models.Match> matches;

    public Competition() {
    }

    public Competition(int id, String name) {
        this.id = id;
        this.name = name;
        this.matches = new HashSet<models.Match>();
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

    @OneToMany(mappedBy = "matches")
    public Set<models.Match> getMatches() {
        return matches;
    }

    public void setMatches(Set<models.Match> matches) {
        this.matches = matches;
    }
}
