package albuquerque.rickandmorty.main.services;

import albuquerque.rickandmorty.main.models.Character;
import java.util.ArrayList;
import java.util.List;

public class CharacterService extends HeadService{
    public List<Character> mountList(String json) {
        return mountList(json, Character.class);
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
}
