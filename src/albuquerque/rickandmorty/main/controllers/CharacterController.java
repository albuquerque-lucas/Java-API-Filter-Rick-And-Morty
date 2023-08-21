package albuquerque.rickandmorty.main.controllers;

import albuquerque.rickandmorty.main.services.CharacterService;
import albuquerque.rickandmorty.main.models.Character;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class CharacterController extends HeadController{
    private final CharacterService characterService;
    public CharacterController() {
        this.characterService = new CharacterService();
    }
    @Override
    protected String getRequestURL() {
        return "https://rickandmortyapi.com/api/character";
    }
    @Override
    protected List<Character> mountList(String json) {
        return characterService.mountList(json);
    }
    @Override
    protected void displayAll(List itemList) {
        characterService.displayAll(itemList);
    }

    public void getById(int characterId) {
        try {
            String requestURL = "https://rickandmortyapi.com/api/character" + "/" + characterId;
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(requestURL))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();
            List<Character> character = characterService.mountCharacter(json);
            characterService.displayAll(character);
        } catch (IOException | InterruptedException e) {
            System.out.println("Ocorreu um erro:");
            System.out.println(e.getMessage());
        }
    }

}
