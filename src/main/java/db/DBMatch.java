package db;

import models.Match;
import models.Team;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBMatch {

    private static Session session;

    public static List<Team> getTeamsFromMatch(Match match) {
        session = HibernateUtil.getSessionFactory().openSession();
        List<Team> results = null;
        try {
            Criteria criteria = session.createCriteria(Team.class);
            criteria.add(Restrictions.eq("match", match));
            results = criteria.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return results;
    }
}
