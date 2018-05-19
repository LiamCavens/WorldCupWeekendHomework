import models.*;
import org.junit.Before;
import org.junit.Test;

import java.util.GregorianCalendar;

import static org.junit.Assert.assertEquals;

public class MatchTest {

    GregorianCalendar date;
    WorldCup worldCup;
    Match match;
    Team team1;
    Team team2;
    Manager manager;
    Stadium stadium;

    @Before
    public void setUp() {
        date= new GregorianCalendar(2018, 8, 19);
        worldCup = new WorldCup("Moscow World Cup");
        match = new Match(date, worldCup);
        manager = new Manager("Jimmy", 20000);
        stadium = new Stadium("Motherwell");
        team1 = new Team("Germany", Continent.EUROPE, "White/Gray", "Green/White", manager, stadium);
        team2 = new Team("Scotland", Continent.EUROPE, "White/Gray", "Green/White", manager, stadium);
    }

    @Test
    public void worldCupHasName() {
        assertEquals("Moscow World Cup", worldCup.getName());
    }

    @Test
    public void matchHasWinner() {
        team1.setGoals(5);
        team2.setGoals(6);
        assertEquals(team2, match.chooseWinner(team1, team2));
    }
}
