package org.academiadecodigo.bootcamp.hackathon.testpackage;

import org.academiadecodigo.bootcamp.hackathon.RNG.RNG;

/**
 * Created by codecadet on 3/16/17.
 */
public class TesterClass {

    public static void main(String[] args) {

        double cadets = 16;
        double seatsByRow = 4;

        double rowsNumber = cadets / seatsByRow;

        double cadetSeat = 11;

        System.out.println("rows number: " + rowsNumber);

        System.out.println(Math.ceil(9/rowsNumber));

        for(int i = 0; i < 10; i ++) {
            System.out.println(RNG.roll());
        }
    }

}