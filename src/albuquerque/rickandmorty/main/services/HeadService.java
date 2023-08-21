package albuquerque.rickandmorty.main.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
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
            FileWriter writer = new FileWriter(getFileName());
            for (Object item : itemList) {
                displayDetails(item);
            }
            System.out.println("Um arquivo foi gerado contendo todas as informações.");
            writer.close();
        } catch (IOException e) {
            e.getMessage();
            e.getCause();
        }
    }

    protected abstract String getFileName();
}
