package albuquerque.rickandmorty.main.services;

import albuquerque.rickandmorty.main.models.Location;
import com.google.gson.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LocationsService extends HeadService{
    public List<Location> mountList(String json) {
        List<Location> locationList = new ArrayList<>();
        JsonObject jsonObject = gson.fromJson(json, JsonObject.class);
        JsonArray resultsArray = jsonObject.getAsJsonArray("results");
        for(JsonElement result : resultsArray) {
            Location newLocation = getNewLocation(result);
            locationList.add(newLocation);
        }
        return locationList;
    }
    @Override
    protected void displayDetails(Object item) {
        Location location = (Location) item;
        System.out.println("Nome: " + location.getName());
        System.out.println("Tipo: " + location.getType());
        System.out.println("Dimensao: " + location.getDimension());
        System.out.println("Url: " + location.getUrl());
        System.out.println("#################################");
    }
    @Override
    protected String getFileName() {
        return "listaLocalizacoes.json";
    }

    public Location getNewLocation(JsonElement result) {
        JsonObject location = result.getAsJsonObject();
        int id = location.get("id").getAsInt();
        String name = location.get("name").getAsString();
        String type = location.get("type").getAsString();
        String dimension = location.get("dimension").getAsString();
        String url = location.get("url").getAsString();
        return new Location(id, name, type, dimension, url);
    }
}
