package models;

import javax.persistence.*;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="matches")
public class Match {

    private int id;
    private GregorianCalendar matchDate;
    private Set<Team> teams;
    private Competition competition;

    public Match() {
    }

    public Match(GregorianCalendar matchDate, Competition competition) {
        this.matchDate = matchDate;
        this.teams = new HashSet<Team>();
        this.competition = competition;
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

    public void addTeamsToMatch(Team team, Team team2){
            if (getTeams().size() < 2) {
                this.teams.add(team);
                this.teams.add(team2);
            }
    }

    public boolean regionalMatch(Team team, Team team2){
        if(team.getContinent() == team2.getContinent()){
            return true;
        } else {
            return false;
        }
    }

    public Continent returnRegionOfMatch(Team team, Team team2){
        if (regionalMatch(team,team2)){
            return team.getContinent();
        }
        return null;
    }

    @ManyToOne
    @JoinColumn(name="competition_id", nullable = false)
    public Competition getCompetition() {
        return competition;
    }

    public void setCompetition(Competition competition) {
        this.competition = competition;
    }
}
