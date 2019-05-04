package com.company;

public class Philosopher implements Runnable {

    private  final Object leftFrok;
    private  final Object rightFrok;

    Philosopher(Object left, Object right){
        this.leftFrok = left;
        this.rightFrok = right;
    }

    private void doAction(String action) throws InterruptedException{
        System.out.println(Thread.currentThread().getName() + " " + action);
        Thread.sleep(((int) (Math.random()*100)));
    }

    @java.lang.Override
    public void run() {
        try {
            while (true){
                doAction(System.nanoTime() + ": Picked up left fork");
                synchronized (rightFrok){
                    doAction(System.nanoTime() + ": Picked up right fork & started to eat");
                    doAction(System.nanoTime() + ": Put down right fork");
                }
                doAction(System.nanoTime() + ": Picked up left fork & returned to start thinking again");
            }
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }
}
