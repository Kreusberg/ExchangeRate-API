package HttpClient;

import com.google.gson.Gson;
import model.Model;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Client {

    public Model sendRequest(String currency) throws IOException, InterruptedException {

        Gson gson = new Gson();

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://v6.exchangerate-api.com/v6/bdaba4a6dae0d79c490c1900/latest/" + currency))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return gson.fromJson(response.body(), Model.class);
    }

}
