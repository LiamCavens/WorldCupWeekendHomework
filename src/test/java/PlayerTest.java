import models.*;
import org.junit.Before;
import org.junit.Test;

import java.util.GregorianCalendar;

import static org.junit.Assert.assertEquals;

public class PlayerTest {

    Player player;
    Team team;
    Manager manager;
    Stadium stadium;

    @Before
    public void setUp() {
        manager = new Manager("Jimmy", 20000);
        stadium = new Stadium("Motherwell");
        team = new Team("Germany", Continent.EUROPE, "White/Gray", "Green/White", manager, stadium);
        player = new Player("Schweinsteiger", team, 200000);
    }

    @Test
    public void playerHasName() {
        assertEquals("Schweinsteiger", player.getName());
    }

    @Test
    public void playerHasTeam() {
        assertEquals(team, player.getTeam());
    }

    @Test
    public void playerHasSalary() {
        assertEquals(200000, player.getSalary());
    }
}
