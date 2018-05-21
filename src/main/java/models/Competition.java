package models;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Competition {

    private int id;
    private String name;
    protected Set<models.Match> matches;

    public Competition() {
    }

    public Competition(String name) {
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

    @OneToMany(mappedBy = "competition")
    public Set<models.Match> getMatches() {
        return matches;
    }

    public void setMatches(Set<models.Match> matches) {
        this.matches = matches;
    }

    public void addMatch(models.Match match){
        this.matches.add(match);
    }

//    public void playTournament(){
//        for(models.Match match : matches)
//        }
//    }
}
