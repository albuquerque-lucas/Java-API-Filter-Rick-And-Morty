package albuquerque.rickandmorty.main.menu;

import albuquerque.rickandmorty.main.controllers.CharacterController;

import java.util.Comparator;
import java.util.Scanner;

public class Menu {
    private final int ALL_CHARACTERS_OPTION = 1;

    private final int CHARACTER_BY_ID_OPTION = 2;
    private final int LOCATIONS_OPTION = 3;
    private final int EPISODES_OPTION = 4;
    private final int EXIT_SYSTEM = 6;
    CharacterController characterController = new CharacterController();
    Scanner scanner = new Scanner(System.in);

    public void show() {
        System.out.println("Selecione por qual filtro voce deseja realizar sua busca.");
        System.out.println(ALL_CHARACTERS_OPTION + " -   Personagens");
        System.out.println(CHARACTER_BY_ID_OPTION + " -   Personagem por ID");
        System.out.println(EPISODES_OPTION + " -   Episodios");
        System.out.println(EXIT_SYSTEM+ " -   Sair do sistema");
    }
    public void select(int option) {
        switch (option) {
            case ALL_CHARACTERS_OPTION:
                System.out.println("Opção selecionada: Personagens");
                characterController.getAll();
                break;
            case CHARACTER_BY_ID_OPTION:
                System.out.println("Opção selecionada: Personagem por id");
                System.out.println("Digite o id do personagem que deseja buscar e aperte Enter");
                int charId = Integer.parseInt(scanner.nextLine());
                characterController.getById(charId);
                break;
            case EPISODES_OPTION:
                System.out.println("Opção selecionada: Episodios");
                break;
            case EXIT_SYSTEM:
                System.out.println("Opção selecionada: Sair do sistema");
                break;
            default:
                System.out.println("Opção inválida");
        }
    }
}
