package me.liyazhou.java7.concurrency.ch2.demo02_arrange_independent_attrs;

/**
 * Created by liyazhou on 2015/7/6.
 */
public class Cinema {
    private long vacanciesCinema1;
    private long vacanciesCinema2;

    private final Object controlCinema1, controlCinema2;

    public Cinema() {
        this.vacanciesCinema1 = 20;
        this.vacanciesCinema2 = 20;
        this.controlCinema1 = new Object();
        this.controlCinema2 = new Object();
    }

    public boolean sellTickets1(int num) {
        synchronized (controlCinema1) {
            if (vacanciesCinema1 > num) {
                vacanciesCinema1 -= num;
                return true;
            } else {
                return false;
            }
        }
    }

    public boolean sellTickets2(int num) {
        synchronized (controlCinema2) {
            if (vacanciesCinema2 > num) {
                vacanciesCinema2 -= num;
                return true;
            } else {
                return false;
            }
        }
    }

    public boolean returnTickets1(int num) {
        synchronized (controlCinema1) {
            vacanciesCinema1 += num;
            return true;
        }
    }

    public boolean returnTickets2(int num) {
        synchronized (controlCinema2) {
            vacanciesCinema2 += num;
            return true;
        }
    }

    public long getVacanciesCinema1() {
        return vacanciesCinema1;
    }

    public long getVacanciesCinema2() {
        return vacanciesCinema2;
    }

}
