package util;


import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import javax.ws.rs.client.ResponseProcessingException;
import java.io.IOException;

public class ApiDistancia {
    private String tempo;
    public ApiDistancia(String destino, String origem) throws ResponseProcessingException, IOException {
      this.tempo = String.format("%.2f", duracao(destino, origem));
    }


    public double duracao(String destino, String origem) throws IOException, ResponseProcessingException {

        OkHttpClient client = new OkHttpClient().newBuilder().build();

        Request request = new Request.Builder()
                .url("https://maps.googleapis.com/maps/api/distancematrix/json?destinations=" + destino + "&origins=" + origem + "&key= chave distantica aqui")
                .get()
                .build();


        Response response = client.newCall(request).execute();
        String data = response.body().string();
        JsonElement jp = new JsonParser().parse(data);
        JsonObject jsonobj = jp.getAsJsonObject();
        JsonArray jarray = jsonobj.getAsJsonArray("rows");
        jsonobj = jarray.get(0).getAsJsonObject();
        jarray = jsonobj.getAsJsonArray("elements");
        jsonobj = jarray.get(0).getAsJsonObject();
        JsonObject valor = (JsonObject) jsonobj.get("duration");
        return (Double.parseDouble(valor.get("value").getAsString()) / 330) / 60;

    }


    public String getTempo() {
        return tempo;
    }
}
