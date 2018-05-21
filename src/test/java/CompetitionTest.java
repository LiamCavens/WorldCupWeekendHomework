import models.*;
import org.junit.Before;
import org.junit.Test;

import java.util.GregorianCalendar;

import static org.junit.Assert.assertEquals;

public class CompetitionTest {

    GregorianCalendar date1;
    GregorianCalendar date2;
    GregorianCalendar date3;

    WorldCup worldCup;

    Match match1;
    Match match2;
    Match match3;

    Manager manager1;
    Manager manager2;
    Manager manager3;
    Manager manager4;
    Manager manager5;
    Manager manager6;

    Stadium stadium1;
    Stadium stadium2;
    Stadium stadium3;
    Stadium stadium4;
    Stadium stadium5;
    Stadium stadium6;

    Team team1;
    Team team2;
    Team team3;
    Team team4;
    Team team5;
    Team team6;

    Player player1;
    Player player2;
    Player player3;
    Player player4;
    Player player5;
    Player player6;
    Player player7;
    Player player8;
    Player player9;
    Player player10;
    Player player11;
    Player player12;

    @Before
    public void setUp() {
        date1 = new GregorianCalendar(2018, 4, 18);
        date2 = new GregorianCalendar(2018, 4, 20);
        date3 = new GregorianCalendar(2018, 4, 22);

        worldCup = new WorldCup("Moscow World Cup");

        match1 = new Match(date1, worldCup);
        match2 = new Match(date2, worldCup);
        match3 = new Match(date3, worldCup);

        manager1 = new Manager("Joachim Löw", 120000);
        manager2 = new Manager("Alex McLeish", 80000);
        manager3 = new Manager("Akira Nishino", 100000);
        manager4 = new Manager("José Pékerman", 95000);
        manager5 = new Manager("Gernot Rohr", 65000);
        manager6 = new Manager("Óscar Ramírez", 98000);

        stadium1 = new Stadium("Berlin");
        stadium2 = new Stadium("Glasgow");
        stadium3 = new Stadium("Tokyo");
        stadium4 = new Stadium("Barranquilla");
        stadium5 = new Stadium("Abuja");
        stadium6 = new Stadium("San Jose");

        team1 = new Team("Germany", Continent.EUROPE, "White/Gray", "Green/White", manager1, stadium1);
        team2 = new Team("Scotland", Continent.EUROPE, "Blue/White", "Pink/White", manager2, stadium2);
        team3 = new Team("Japan", Continent.ASIA, "Blue/Blue", "Grey/White", manager3, stadium3);
        team4 = new Team("Columbia", Continent.SOUTHAMERICA, "Yellow/Black", "Blue/Red", manager4, stadium4);
        team5 = new Team("Nigeria", Continent.AFRICA, "Light Green", "Dark Green", manager5, stadium5);
        team6 = new Team("Costa Rica", Continent.NORTHAMERICA, "Red/Blue", "White/White", manager6, stadium6);

        player1 = new Player("Schweinsteiger", team1, 200000);
        player2 = new Player("Kroos", team1, 202000);
        player3 = new Player("Brown", team2, 120000);
        player4 = new Player("Tierney", team2, 90000);
        player5 = new Player("Akimo", team3, 30000);
        player6 = new Player("Hishima", team3, 110000);
        player7 = new Player("Falcao", team4, 120000);
        player8 = new Player("Borka", team4, 95000);
        player9 = new Player("Moses", team5, 90000);
        player10 = new Player("Musa", team5, 120000);
        player11 = new Player("Navas", team6, 190000);
        player12 = new Player("Ruiz", team6, 180000);

        team1.setGoals(1);
        team2.setGoals(6);
        team3.setGoals(2);
        team4.setGoals(3);
        team5.setGoals(4);
        team6.setGoals(5);
    }

    @Test
    public void competitionHasName() {
        assertEquals("Moscow World Cup", worldCup.getName());
    }

    @Test
    public void canAddMatches() {
        worldCup.addMatch(match1);
        worldCup.addMatch(match2);
        assertEquals(2, worldCup.getMatches().size());
    }

}
