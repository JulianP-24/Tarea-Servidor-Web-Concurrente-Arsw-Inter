package edu.escuelaing.arsw.app.EjerciciosClase;

public class HelloRunnable implements Runnable{
    public void run(){
        System.out.println("hello from runnable" + Thread.currentThread());
    }

    public static void main(String[] args){
        System.out.println("Hello from main: " + Thread.currentThread());
        Thread t = new Thread(new HelloRunnable());
        t.start();
    }
}