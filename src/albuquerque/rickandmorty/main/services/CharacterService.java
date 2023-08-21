package albuquerque.rickandmorty.main.services;

import albuquerque.rickandmorty.main.models.Character;
import com.google.gson.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CharacterService extends HeadService{
    public List<Character> mountList(String json) {
        List<Character> characterList = new ArrayList<>();
        JsonObject jsonObject = gson.fromJson(json, JsonObject.class);
        JsonArray resultsArray = jsonObject.getAsJsonArray("results");
        for(JsonElement result : resultsArray) {
            Character newCharacter = getNewCharacter(result);
            characterList.add(newCharacter);
        }
        return characterList;
    }

    public List<Character> mountCharacter(String json) {
        List<Character> characterList = new ArrayList<>();
        Character character = gson.fromJson(json, Character.class);
        characterList.add(character);
        return characterList;
    }
    @Override
    public void displayDetails(Object item) {
        Character character = (Character) item;
        System.out.println("Nome: " + character.getName());
        System.out.println("Especie: " + character.getSpecies());
        System.out.println("Genero: " + character.getGender());
        System.out.println("Status: " + character.getStatus());
        System.out.println("Imagem: " + character.getImage());
    }
    @Override
    protected String getFileName() {
        return "listaPersonagens.json";
    }
//    public void displayAll(List<Character> characterList) {
//        try {
//            FileWriter writer = new FileWriter("listaPersonagens.json");
//            String json = gsonWithPrettyPrinting.toJson(characterList);
//            writer.write(json);
//            for (Character character : characterList) {
//                System.out.println("Nome: " + character.getName());
//                System.out.println("Especie: " + character.getSpecies());
//                System.out.println("Genero: " + character.getGender());
//                System.out.println("Status: " + character.getStatus());
//                System.out.println("Imagem: " + character.getImage());
//            }
//            System.out.println("Um arquivo foi gerado contendo todas as informacoes.");
//            writer.close();
//        } catch (IOException e) {
//            e.getMessage();
//            e.getCause();
//        }
//    }


    private Character getNewCharacter(JsonElement result) {
        JsonObject character = result.getAsJsonObject();
        int id = character.get("id").getAsInt();
        String name = character.get("name").getAsString();
        String status = character.get("status").getAsString();
        String species = character.get("species").getAsString();
        String gender = character.get("gender").getAsString();
        String image = character.get("image").getAsString();
        return new Character(id, name, status, species, gender, image);
    }
}
