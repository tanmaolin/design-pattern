package com.jxcc;

/**
 * @author tanmaolin
 * @date 2022-09-29 14:59
 */
public class Facade {
}

class HomeFacade {
    private Popcorn popcorn;
    private DVDPlayer dvdPlayer;

    public HomeFacade() {
        this.popcorn = Popcorn.getInstance();
        this.dvdPlayer = DVDPlayer.getInstance();
    }

    public void ready() {
        popcorn.on();
        dvdPlayer.on();
    }

    public void play() {

    }
    public void end() {
        dvdPlayer.down();
    }

}

class DVDPlayer {
    private static DVDPlayer instance = new DVDPlayer();

    public static DVDPlayer getInstance() {
        return instance;

    }

    public void on() {
        System.out.println(" dvd on");
    }

    public void down() {
        System.out.println(" dvd down");
    }
}

class Popcorn {
    private static Popcorn instance = new Popcorn();

    public static Popcorn getInstance() {
        return instance;
    }

    public void on() {
        System.out.println(" pop on");
    }

    public void down() {
        System.out.println(" pop down");
    }
}