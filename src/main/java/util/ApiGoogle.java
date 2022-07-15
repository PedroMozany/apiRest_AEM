package util;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import model.Usuario;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiGoogle {

    public static Usuario validarToken(String Token) throws IOException {
        URL url = new URL("https://www.googleapis.com/oauth2/v3/tokeninfo?id_token=" + Token);
        HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
        conexao.connect();

        System.out.println(conexao);
        JsonParser jp = new JsonParser();
        JsonElement root = jp.parse(new InputStreamReader((InputStream) conexao.getContent()));
        JsonObject object = root.getAsJsonObject();
        String nome = object.get("name").getAsString();
        String email = object.get("email").getAsString();


       return  new Usuario(nome,email);
    }
}
