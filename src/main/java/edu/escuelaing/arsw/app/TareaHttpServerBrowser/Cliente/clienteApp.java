package edu.escuelaing.arsw.app.TareaHttpServerBrowser.Cliente;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class clienteApp {
    public static void main(String[] args) throws IOException {

        ExecutorService poolHilos = Executors.newFixedThreadPool(100);

        for (int i = 0; i < 200; i++) {

            clientePruebas pruebaHilos = new clientePruebas();
            poolHilos.execute(pruebaHilos);
        }

    }
}
