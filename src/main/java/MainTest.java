import org.academiadecodigo.bootcamp.hackathon.model.Bootcamp;
import org.academiadecodigo.bootcamp.hackathon.model.Cadet;
import org.academiadecodigo.bootcamp.hackathon.model.Summarizer;
import org.academiadecodigo.bootcamp.hackathon.model.dao.hibernate.HibernateBootcampDao;
import org.academiadecodigo.bootcamp.hackathon.model.dao.hibernate.HibernateCadetDao;
import org.academiadecodigo.bootcamp.hackathon.model.dao.hibernate.HibernateSummarizerDao;
import org.academiadecodigo.bootcamp.hackathon.persistence.hibernate.HibernateSessionManager;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

/**
 * Created by codecadet on 3/16/17.
 */
public class MainTest {

    public static void main(String[] args) {

        HibernateSessionManager hibernate = new HibernateSessionManager();
        hibernate.getSession();

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setName("Javangers");

        Cadet cadet1 = new Cadet();
        cadet1.setName("Antonio");
        cadet1.setAvailableToSummerize(true);
        cadet1.setCurrentSeat(0);

        Cadet cadet2 = new Cadet();
        cadet2.setName("Joao");
        cadet2.setAvailableToSummerize(true);
        cadet2.setCurrentSeat(0);

        Set<Cadet> cadets = new HashSet<>();

        cadets.add(cadet1);
        cadets.add(cadet2);

        bootcamp.setCadets(cadets);

        Summarizer summarizer1 = new Summarizer();
        summarizer1.setCadetAssigned(cadet1);
        summarizer1.setDate(new Date(2017, 3, 15));
        summarizer1.setSummarizerNumber(2);


        HibernateBootcampDao bootcampDao = new HibernateBootcampDao();
        HibernateCadetDao cadetDao = new HibernateCadetDao();
        HibernateSummarizerDao summarizerDao = new HibernateSummarizerDao();

        hibernate.beginTransaction();

        bootcampDao.create(bootcamp);

        //cadetDao.create(cadet1);
        //cadetDao.create(cadet2);

        summarizerDao.create(summarizer1);

        hibernate.commitTransaction();

        hibernate.beginTransaction();

        System.out.println(cadetDao.findByName(cadet1.getName()).getBootcamp().getName());

        hibernate.commitTransaction();

        System.out.println(cadet1.getBootcamp());

    }
}
