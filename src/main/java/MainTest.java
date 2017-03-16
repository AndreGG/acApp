import org.academiadecodigo.bootcamp.hackathon.model.Bootcamp;
import org.academiadecodigo.bootcamp.hackathon.model.Cadet;
import org.academiadecodigo.bootcamp.hackathon.model.Summarizer;
import org.academiadecodigo.bootcamp.hackathon.model.dao.hibernate.HibernateBootcampDao;
import org.academiadecodigo.bootcamp.hackathon.model.dao.hibernate.HibernateCadetDao;
import org.academiadecodigo.bootcamp.hackathon.model.dao.hibernate.HibernateSummarizerDao;
import org.academiadecodigo.bootcamp.hackathon.persistence.hibernate.HibernateSessionManager;

import java.sql.Date;

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


        Summarizer summarizer1 = new Summarizer();
        summarizer1.setCadetAssigned(cadet1);
        summarizer1.setDate(new Date(2017, 3, 15));
        summarizer1.setSummarizerNumber(2);


        HibernateBootcampDao bootcampDao = new HibernateBootcampDao();
        HibernateCadetDao cadetDao = new HibernateCadetDao();
        HibernateSummarizerDao summarizerDao = new HibernateSummarizerDao();

        hibernate.beginTransaction();

        bootcampDao.create(bootcamp);

        cadetDao.create(cadet1);
        cadetDao.create(cadet2);

        summarizerDao.create(summarizer1);

        hibernate.commitTransaction();
    }
}