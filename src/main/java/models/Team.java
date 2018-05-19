package models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="teams")
public class Team {

    private int id;
    private String country;
    private Continent continent;
    private String homeColours;
    private String awayColours;
    private Manager manager;
    private Stadium stadium;
    private Set<Player> players;
    private Set<models.Match> matches;
    private int goals;

    public Team() {
    }

    public Team(String country, Continent continent, String homeColours, String awayColours, Manager manager, Stadium stadium) {
        this.country = country;
        this.continent = continent;
        this.homeColours = homeColours;
        this.awayColours = awayColours;
        this.manager = manager;
        this.stadium = stadium;
        this.players = new HashSet<Player>();
        this.matches = new HashSet<models.Match>();
        this.goals = 0;
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

    @Column(name="country")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Enumerated(EnumType.STRING)
    public Continent getContinent() {
        return continent;
    }

    public void setContinent(Continent continent) {
        this.continent = continent;
    }

    @Column(name="home_colours")
    public String getHomeColours() {
        return homeColours;
    }

    public void setHomeColours(String homeColours) {
        this.homeColours = homeColours;
    }

    @Column(name="away_colours")
    public String getAwayColours() {
        return awayColours;
    }

    public void setAwayColours(String awayColours) {
        this.awayColours = awayColours;
    }

    @OneToOne(cascade = CascadeType.PERSIST)
    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    @OneToOne(cascade = CascadeType.PERSIST)
    public Stadium getStadium() {
        return stadium;
    }

    public void setStadium(Stadium stadium) {
        this.stadium = stadium;
    }

    @OneToMany(mappedBy = "team")
    public Set<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Set<Player> players) {
        this.players = players;
    }

    public void addPlayer(Player player){
        this.players.add(player);
    }

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name="team_matches",
            inverseJoinColumns = {@JoinColumn(name="match_id", nullable = false, updatable = false)},
            joinColumns = {@JoinColumn(name="team_id", nullable = false, updatable = false)}
    )
    public Set<models.Match> getMatches() {
        return matches;
    }

    public void setMatches(Set<models.Match> matches) {
        this.matches = matches;
    }

    public void addMatch(models.Match match){
        this.matches.add(match);
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }
}
