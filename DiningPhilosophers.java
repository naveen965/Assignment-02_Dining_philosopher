package com.company;

public class DiningPhilosophers {
    public static void main(String[] args) {
        Philosopher[] philosophers = new Philosopher[5];
        Object[] forks = new Object[philosophers.length];

        for(int i = 0; i<forks.length; i++){
            forks[i] = new Object();
        }

        for(int j = 0; j<philosophers.length; j++){
            Object leftFrok = forks[j];
            Object rightFrok = forks[(j+1) % forks.length];

            if(j == philosophers.length - 1){
                philosophers[j] = new Philosopher(rightFrok, leftFrok);
            }else {
                philosophers[j] = new Philosopher(leftFrok, rightFrok);
            }

            Thread thread = new Thread(philosophers[j], "Philosopher " + (j+1));
            thread.start();
        }
    }
}
