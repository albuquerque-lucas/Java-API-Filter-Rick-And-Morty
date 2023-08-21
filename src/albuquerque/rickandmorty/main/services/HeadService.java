package albuquerque.rickandmorty.main.services;

import com.google.gson.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class HeadService {
    protected final Gson gsonWithPrettyPrinting;
    protected final Gson gson;

    protected HeadService() {
        this.gsonWithPrettyPrinting = new GsonBuilder().setPrettyPrinting().create();
        this.gson = new Gson();
    }

    protected abstract void displayDetails(Object item);

    public void displayAll(List<?> itemList) {
        try {
            String json = gsonWithPrettyPrinting.toJson(itemList);
            String filename = getFileName();
            if (itemList.size() < 2) {
                filename = "singleCharacter.json";
            }
            FileWriter writer = new FileWriter(filename);
            writer.write(json);
            for (Object item : itemList) {
                displayDetails(item);
            }
            System.out.println("Um arquivo foi gerado contendo todas as informações pesquisadas.");
            writer.close();
        } catch (IOException e) {
            e.getMessage();
            e.getCause();
        }
    }

    protected <T> List<T> mountList(String json, Class<T> elementType) {
        List<T> itemList = new ArrayList<>();
        JsonArray resultsArray = gson.fromJson(json, JsonObject.class).getAsJsonArray("results");
        for (JsonElement result : resultsArray) {
            T newItem = gson.fromJson(result, elementType);
            itemList.add(newItem);
        }
        return itemList;
    }

    protected abstract String getFileName();
}
