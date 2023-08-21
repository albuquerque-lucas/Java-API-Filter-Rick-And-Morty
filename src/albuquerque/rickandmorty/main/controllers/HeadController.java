package albuquerque.rickandmorty.main.controllers;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public abstract class HeadController<T> {
    protected final HttpClient client = HttpClient.newHttpClient();
    protected abstract String getRequestURL();
    protected abstract List<T> mountList(String Json);
    public void getAll() {
        try {
            String requestUrl = getRequestURL();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(requestUrl))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();
            List<T> itemList = mountList(json);
            displayAll(itemList);
        } catch (IOException | InterruptedException e) {
            System.out.println("Ocorreu um erro:");
            System.out.println(e.getMessage());
        }
    }

    protected abstract void displayAll(List<T> itemList);
}
