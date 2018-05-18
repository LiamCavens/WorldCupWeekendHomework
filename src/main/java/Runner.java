import db.DBHelper;
import db.DBMatch;
import models.*;

import java.util.GregorianCalendar;
import java.util.List;

public class Runner {

    public static void main(String[] args) {

        GregorianCalendar date1 = new GregorianCalendar(2018, 4, 18);
        GregorianCalendar date2 = new GregorianCalendar(2018, 4, 20);
        GregorianCalendar date3 = new GregorianCalendar(2018, 4, 22);

        WorldCup worldCup = new WorldCup("Moscow World Cup");

        Match match1 = new Match(date1, worldCup);
        Match match2 = new Match(date2, worldCup);
        Match match3 = new Match(date3, worldCup);

        Manager manager1 = new Manager("Joachim Löw", 120000);
        Manager manager2 = new Manager("Alex McLeish", 80000);
        Manager manager3 = new Manager("Akira Nishino", 100000);
        Manager manager4 = new Manager("José Pékerman", 95000);
        Manager manager5 = new Manager("Gernot Rohr", 65000);
        Manager manager6 = new Manager("Óscar Ramírez", 98000);

        Stadium stadium1 = new Stadium("Berlin");
        Stadium stadium2 = new Stadium("Glasgow");
        Stadium stadium3 = new Stadium("Tokyo");
        Stadium stadium4 = new Stadium("Barranquilla");
        Stadium stadium5 = new Stadium("Abuja");
        Stadium stadium6 = new Stadium("San Jose");

        Team team1 = new Team("Germany", Continent.EUROPE, "White/Gray", "Green/White", manager1, stadium1);
        Team team2 = new Team("Scotland", Continent.EUROPE, "Blue/White", "Pink/White", manager2, stadium2);
        Team team3 = new Team("Japan", Continent.ASIA, "Blue/Blue", "Grey/White", manager3, stadium3);
        Team team4 = new Team("Columbia", Continent.SOUTHAMERICA, "Yellow/Black", "Blue/Red", manager4, stadium4);
        Team team5 = new Team("Nigeria", Continent.AFRICA, "Light Green", "Dark Green", manager5, stadium5);
        Team team6 = new Team("Costa Rica", Continent.NORTHAMERICA, "Red/Blue", "White/White", manager6, stadium6);

        Player player1 = new Player("Schweinsteiger", team1, 200000);
        Player player2 = new Player("Kroos", team1, 202000);
        Player player3 = new Player("Brown", team2, 120000);
        Player player4 = new Player("Tierney", team2, 90000);
        Player player5 = new Player("Akimo", team3, 30000);
        Player player6 = new Player("Hishima", team3, 110000);
        Player player7 = new Player("Falcao", team4, 120000);
        Player player8 = new Player("Borka", team4, 95000);
        Player player9 = new Player("Moses", team5, 90000);
        Player player10 = new Player("Musa", team5, 120000);
        Player player11 = new Player("Navas", team6, 190000);
        Player player12 = new Player("Ruiz", team6, 180000);

        DBHelper.saveOrUpdate(worldCup);
        DBHelper.saveOrUpdate(match1);
        DBHelper.saveOrUpdate(match2);
        DBHelper.saveOrUpdate(match3);
        DBHelper.saveOrUpdate(manager1);
        DBHelper.saveOrUpdate(manager2);
        DBHelper.saveOrUpdate(manager3);
        DBHelper.saveOrUpdate(manager4);
        DBHelper.saveOrUpdate(manager5);
        DBHelper.saveOrUpdate(manager6);
        DBHelper.saveOrUpdate(stadium1);
        DBHelper.saveOrUpdate(stadium2);
        DBHelper.saveOrUpdate(stadium3);
        DBHelper.saveOrUpdate(stadium4);
        DBHelper.saveOrUpdate(stadium5);
        DBHelper.saveOrUpdate(stadium6);
        DBHelper.saveOrUpdate(team1);
        DBHelper.saveOrUpdate(team2);
        DBHelper.saveOrUpdate(team3);
        DBHelper.saveOrUpdate(team4);
        DBHelper.saveOrUpdate(team5);
        DBHelper.saveOrUpdate(team6);
        DBHelper.saveOrUpdate(player1);
        DBHelper.saveOrUpdate(player2);
        DBHelper.saveOrUpdate(player3);
        DBHelper.saveOrUpdate(player4);
        DBHelper.saveOrUpdate(player5);
        DBHelper.saveOrUpdate(player6);
        DBHelper.saveOrUpdate(player7);
        DBHelper.saveOrUpdate(player8);
        DBHelper.saveOrUpdate(player9);
        DBHelper.saveOrUpdate(player10);
        DBHelper.saveOrUpdate(player11);
        DBHelper.saveOrUpdate(player12);

        List<Team> allTeams = DBHelper.getAll(Team.class);

        match1.addTeamsToMatch(team1, team2);
        match2.addTeamsToMatch(team3, team4);
        match3.addTeamsToMatch(team5, team6);

    }
}
