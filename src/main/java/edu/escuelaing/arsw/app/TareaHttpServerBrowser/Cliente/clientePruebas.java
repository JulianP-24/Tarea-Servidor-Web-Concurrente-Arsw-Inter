package edu.escuelaing.arsw.app.TareaHttpServerBrowser.Cliente;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class clientePruebas implements Runnable{
    
    @Override
    public void run() {
        String Url = "https://cryptic-castle-98984.herokuapp.com/";
    
        try {
            getRequest(Url);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public String getRequest(String Url) throws IOException
    {
        String ans = "";
        try{
            URL url=new URL(Url);
            //System.out.println(url);
            HttpURLConnection urlconection=(HttpURLConnection) url.openConnection();
            System.out.println(urlconection);
            urlconection.setRequestMethod("GET");

            BufferedReader input= new BufferedReader(new InputStreamReader(urlconection.getInputStream()));
            String inputline;
            StringBuffer content=new StringBuffer();
            while ((inputline = input.readLine()) !=null)
            {
                content.append(inputline);

            }
            
            input.close();
            urlconection.disconnect();
            ans = content.toString();
            System.out.println(ans);
            return ans;
        } catch (MalformedURLException e)
        {
            e.printStackTrace();
        }
        return ans;

    }

    
}
