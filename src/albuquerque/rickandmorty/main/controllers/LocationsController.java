package albuquerque.rickandmorty.main.controllers;

import albuquerque.rickandmorty.main.models.Location;
import albuquerque.rickandmorty.main.services.LocationsService;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class LocationsController {
    private final HttpClient client = HttpClient.newHttpClient();
    private final LocationsService locationsService = new LocationsService();
    public void getAll() {
        try {
            String requestURL = "https://rickandmortyapi.com/api/location";
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(requestURL))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();
            List<Location> locationList = locationsService.mountList(json);
            locationsService.displayAll(locationList);
        } catch (IOException | InterruptedException e) {
            System.out.println("Ocorreu um erro:");
            System.out.println(e.getMessage());
        }
    }
}
