package models;

import javax.persistence.*;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

public class Match {

    private int id;
    private GregorianCalendar matchDate;
    private Set<Team> teams;

    public Match() {
    }

    public Match(GregorianCalendar matchDate) {
        this.matchDate = matchDate;
        this.teams = new HashSet<Team>();
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

    @Column(name="match_date")
    public GregorianCalendar getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(GregorianCalendar matchDate) {
        this.matchDate = matchDate;
    }

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name="team_matches",
            inverseJoinColumns = {@JoinColumn(name="team_id", nullable = false, updatable = false)},
            joinColumns = {@JoinColumn(name="match_id", nullable = false, updatable = false)}
    )
    public Set<Team> getTeams() {
        return teams;
    }

    public void setTeams(Set<Team> teams) {
        this.teams = teams;
    }

    public void addTeam(Team team){
        if (getTeams().size() < 2){
            this.teams.add(team);
        }
    }
}
