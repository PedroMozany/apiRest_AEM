package util;



import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiClima {

    public String calcClima(String cidade) throws IOException {
        String[] index = cidade.split("-");
        String cidadeCorreta = index[0].trim().replace(" ", "%20");
        URL url = new URL("https://api.openweathermap.org/data/2.5/weather?q="+cidadeCorreta+"&units=metric&lang=pt_br&APPID=f35065069b65d05ae8fc4ff470d4c910");
        HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
        conexao.connect();
        System.out.println(conexao);

        JsonParser jp = new JsonParser();
        JsonElement root = jp.parse(new InputStreamReader((InputStream) conexao.getContent()));
        JsonObject jsonobj = root.getAsJsonObject();
        JsonObject objs = (JsonObject) jsonobj.get("main");
        String temp = objs.get("temp").getAsString();
        System.out.println(temp);

        return temp;
    }
}
