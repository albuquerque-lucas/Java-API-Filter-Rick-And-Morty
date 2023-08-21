package albuquerque.rickandmorty.main.services;

import albuquerque.rickandmorty.main.models.Character;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

public class CharacterService {
    
    private final Gson gson = new Gson();
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

    public Character mountCharacter(String json) {
        return gson.fromJson(json, Character.class);
    }
    public void displayCharacter(Character character) {
            System.out.println("Nome: " + character.getName());
            System.out.println("Especie: " + character.getSpecies());
            System.out.println("Genero: " + character.getGender());
            System.out.println("Status: " + character.getStatus());
            System.out.println("Imagem: " + character.getImage());
            System.out.println("#################################");
    }
    public void displayAll(List<Character> characterList) {
        for (Character character : characterList) {
            System.out.println("Nome: " + character.getName());
            System.out.println("Especie: " + character.getSpecies());
            System.out.println("Genero: " + character.getGender());
            System.out.println("Status: " + character.getStatus());
            System.out.println("Imagem: " + character.getImage());
            System.out.println("#################################");
        }
    }

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
