package edu.escuelaing.arsw.app.EjerciciosClase;

import java.time.LocalDateTime;

public class HelloRunnableWithJoin implements Runnable{
    static Thread threadActual;
    public void run(){

        try {
            threadActual.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Hello from a thread time: " + LocalDateTime.now());
    }

    public static void main(String[] args){
        Thread t = new Thread(new HelloRunnableWithJoin());
        threadActual = Thread.currentThread();
        t.start();
        System.out.println("Hello from main thread time: " + LocalDateTime.now());
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
