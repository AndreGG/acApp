package org.academiadecodigo.bootcamp.hackathon.testpackage;

import org.academiadecodigo.bootcamp.hackathon.model.Bootcamp;
import org.academiadecodigo.bootcamp.hackathon.model.Cadet;
import org.academiadecodigo.bootcamp.hackathon.model.dao.BootcampDao;
import org.academiadecodigo.bootcamp.hackathon.model.dao.hibernate.HibernateBootcampDao;
import org.academiadecodigo.bootcamp.hackathon.persistence.hibernate.HibernateSessionManager;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by codecadet on 3/17/17.
 */
public class SQLLoader {

    private HibernateSessionManager manager;

    public SQLLoader(HibernateSessionManager manager) {

        this.manager = manager;

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

        for (Cadet cadet : cadetList) {
            cadets.add(cadet);
        }

        bootcamp.setCadets(cadets);

    }

}
