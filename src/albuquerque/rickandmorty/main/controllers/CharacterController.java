package albuquerque.rickandmorty.main.controllers;

import albuquerque.rickandmorty.main.services.CharacterService;
import albuquerque.rickandmorty.main.models.Character;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class CharacterController {
    private final HttpClient client = HttpClient.newHttpClient();

    public void getAll() {
        try {
            CharacterService characterService = new CharacterService();
            String requestURL = "https://rickandmortyapi.com/api/character";
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(requestURL))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();
            List<Character> characterList = characterService.createList(json);
            characterService.displayAll(characterList);
        } catch(IOException | InterruptedException e) {
            System.out.println("Ocorreu um erro:");
            System.out.println(e.getMessage());
        }

    }

    public void getById(int characterId) {
        try {
            CharacterService characterService = new CharacterService();
            String requestURL = "https://rickandmortyapi.com/api/character" + "/" + characterId;
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(requestURL))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();
            Character character = characterService.createCharacter(json);
            characterService.displayCharacter(character);
        } catch (IOException | InterruptedException e) {
            System.out.println("Ocorreu um erro:");
            System.out.println(e.getMessage());
        }
    }

}