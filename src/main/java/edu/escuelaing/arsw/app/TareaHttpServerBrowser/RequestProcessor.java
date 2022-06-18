package edu.escuelaing.arsw.app.TareaHttpServerBrowser;

import edu.escuelaing.arsw.app.TareaHttpServerBrowser.Reader.FilesReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class RequestProcessor implements Runnable {

    private final Socket clientSocket;
    public static FilesReader fileReader = new FilesReader();

    public RequestProcessor(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    public void run() {
        try {
            process();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void process() throws IOException {
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String inputLine;
        String path = "";
        while ((inputLine = in.readLine()) != null) {
            if (inputLine.contains("GET")) {
                path = inputLine.split("/")[1];
                path = path.split(" ")[0];
                if (path.contains(".jpg")) {
                    fileReader.img("/src/main/resources/" + path, clientSocket.getOutputStream());
                } else if (path.contains(".html")) {
                    fileReader.html("/src/main/resources/" + path, clientSocket.getOutputStream());
                } else if (path.contains(".js")) {
                    fileReader.js("/src/main/resources/" + path, clientSocket.getOutputStream());
                } else if (path.contains(".css")) {
                    fileReader.css("/src/main/resources/" + path, clientSocket.getOutputStream());
                } else if (path.equals("")) {
                    fileReader.html("/src/main/resources/index.html", clientSocket.getOutputStream());
                } else if ((!path.contains(".html")) || (!path.contains(".js")) || (!path.contains(".css")) || (!path
                        .contains(".jpg"))) {
                    fileReader.PageNotFound("/src/main/resources/" + path, clientSocket.getOutputStream());
                }

            }
            System.out.println("Received: " + inputLine);
            if (!in.ready()) {
                break;
            }

        }
        out.close();
        in.close();
        clientSocket.close();
    }
}
