package org.academiadecodigo.bootcamp.hackathon.RNG;

/**
 * Created by codecadet on 3/16/17.
 */
public final class RNG {

    public static int getRandomNumber(int number) {
        return (int)(Math.random() * number);
    }

    public static int roll() {
        return (int)(Math.random() * 100);
    }

}
