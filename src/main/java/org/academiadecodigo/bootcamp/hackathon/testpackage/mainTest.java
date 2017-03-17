package org.academiadecodigo.bootcamp.hackathon.testpackage;

import javafx.application.Application;
import javafx.stage.Stage;
import org.academiadecodigo.bootcamp.hackathon.model.Bootcamp;
import org.academiadecodigo.bootcamp.hackathon.model.Cadet;
import org.academiadecodigo.bootcamp.hackathon.model.Summarizer;
import org.academiadecodigo.bootcamp.hackathon.model.dao.hibernate.HibernateBootcampDao;
import org.academiadecodigo.bootcamp.hackathon.model.dao.hibernate.HibernateCadetDao;
import org.academiadecodigo.bootcamp.hackathon.model.dao.hibernate.HibernateSummarizerDao;
import org.academiadecodigo.bootcamp.hackathon.navigation.Navigator;
import org.academiadecodigo.bootcamp.hackathon.persistence.TransactionManager;
import org.academiadecodigo.bootcamp.hackathon.persistence.hibernate.HibernateTransactionManager;
import org.academiadecodigo.bootcamp.hackathon.services.SeatTestService;
import org.academiadecodigo.bootcamp.hackathon.services.ServiceInitializer;
import org.academiadecodigo.bootcamp.hackathon.services.ServiceRegistry;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


/**
 * Created by codecadet on 3/16/17.
 */
public class mainTest extends Application{

    @Override
    public void init() {

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setName("Javangers");

        ArrayList<Cadet> cadetList = new ArrayList<>();

        Cadet cadet1 = new Cadet();
        cadet1.setName("António");
        cadet1.setAvailableToSummerize(true);
        cadet1.setCurrentSeat(0);
        cadetList.add(cadet1);

        Cadet cadet2 = new Cadet();
        cadet2.setName("Amaral");
        cadet2.setAvailableToSummerize(true);
        cadet2.setCurrentSeat(0);
        cadetList.add(cadet2);

        Cadet cadet3 = new Cadet();
        cadet3.setName("Chapa");
        cadetList.add(cadet3);

        Cadet cadet4 = new Cadet();
        cadet4.setName("Luizord");
        cadetList.add(cadet4);

        Cadet cadet5 = new Cadet();
        cadet5.setName("Tiago");
        cadetList.add(cadet5);

        Cadet cadet6 = new Cadet();
        cadet6.setName("Branco");
        cadetList.add(cadet6);

        Cadet cadet7 = new Cadet();
        cadet7.setName("Giuliano");
        cadetList.add(cadet7);

        Cadet cadet8 = new Cadet();
        cadet8.setName("Alexandre");
        cadetList.add(cadet8);

        Cadet cadet9 = new Cadet();
        cadet9.setName("Peter");
        cadetList.add(cadet9);

        Cadet cadet10 = new Cadet();
        cadet10.setName("Micael");
        cadetList.add(cadet10);

        Cadet cadet11 = new Cadet();
        cadet11.setName("Campos");
        cadetList.add(cadet11);

        Cadet cadet12 = new Cadet();
        cadet12.setName("Root");
        cadetList.add(cadet12);

        Cadet cadet13 = new Cadet();
        cadet13.setName("Vero");
        cadetList.add(cadet13);

        Cadet cadet14 = new Cadet();
        cadet14.setName("Boni");
        cadetList.add(cadet14);

        Cadet cadet15 = new Cadet();
        cadet15.setName("Joaquim");
        cadetList.add(cadet15);

        Cadet cadet16 = new Cadet();
        cadet16.setName("André");
        cadetList.add(cadet16);

        Cadet cadet17 = new Cadet();
        cadet17.setName("Rúben");
        cadetList.add(cadet17);

        Set<Cadet> cadets = new HashSet<>();

        for(Cadet cadet: cadetList) {
            cadets.add(cadet);
        }

        bootcamp.setCadets(cadets);

        Summarizer summarizer1 = new Summarizer();
        summarizer1.setCadetAssigned(cadet1);
        summarizer1.setDate(new Date(2017, 3, 15));
        summarizer1.setSummarizerNumber(2);


        HibernateBootcampDao bootcampDao = new HibernateBootcampDao();
        HibernateCadetDao cadetDao = new HibernateCadetDao();
        HibernateSummarizerDao summarizerDao = new HibernateSummarizerDao();
        TransactionManager transactionManager = new HibernateTransactionManager();

        transactionManager.beginTransaction();

        bootcampDao.create(bootcamp);

        cadetDao.create(cadet1);
        cadetDao.create(cadet2);

        summarizerDao.create(summarizer1);

        transactionManager.commitTransaction();

        SeatTestService service = new SeatTestService(cadetDao, transactionManager);
        ServiceRegistry.getInstance().registerService(service);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Navigator.getInstance().setStage(primaryStage);
        Navigator.getInstance().loadScreen("seating");
        ServiceInitializer sInit = new ServiceInitializer();
        sInit.init();

    }

    @Override
    public void stop() {

    }

    public static void main(String[] args) {
        launch(args);
    }

}



