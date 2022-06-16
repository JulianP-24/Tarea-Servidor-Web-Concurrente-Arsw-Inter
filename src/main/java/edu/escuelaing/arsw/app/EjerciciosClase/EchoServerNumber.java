package edu.escuelaing.arsw.app.EjerciciosClase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServerNumber {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(35000);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 35000.");
            System.exit(1);
        }
        Socket clientSocket = null;
        try {
            clientSocket = serverSocket.accept();
        } catch (IOException e) {
            System.err.println("Accept failed.");
            System.exit(1);
        }
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String inputLine, outputLine;
        //System.out.println("Ingresa un número para calcular su el cuadrado de este.");
        while ((inputLine = in.readLine()) != null) {
            System.out.println("Mensaje: " + inputLine);
            //int numero = Integer.parseInt(inputLine);
            //outputLine = "Respuesta: " + (numero*numero);
            outputLine = "Respuesta: " + (inputLine);
            out.println(outputLine);
            if (outputLine.equals("Respuesta: Bye.")) {
                break;
            }
        }
        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();
    }
}