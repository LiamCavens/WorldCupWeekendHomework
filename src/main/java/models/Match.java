package models;

import javax.persistence.*;
import java.util.*;

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

//    public Team playMatch(Match match){
//        ArrayList score = new ArrayList<Integer>();
//        score.add(0, 0);
//        score.add(1, 1);
//        score.add(2, 2);
//        score.add(3, 3);
//        score.add(4, 4);
//        score.add(5, 5);
//        Random randomGenerator = new Random();
//
//        for(Team team : teams){
//            team.setGoals(randomGenerator.nextInt(score.size()));
//            System.out.println(team.getCountry() + " Score:" + team.getGoals());
//            //return team with most goals
//
//        }
//    }

    public Team chooseWinner(Team team1, Team team2){
//        ArrayList teams = new ArrayList<Team>();
//        teams.add(team1);
//        teams.add(team2);
//        Random r = new Random();
//        Team randomTeam = (Team)teams.get(r.nextInt(teams.size()));
//        teams.add(team1);
//        teams.add(team2);
        if (team1.getGoals() > team2.getGoals()){
            return team1;
        } else {
            return team2;
        }

//         else {
//            System.out.println("Game goes to penalties");
//            return randomTeam;
//        }
    }
}
