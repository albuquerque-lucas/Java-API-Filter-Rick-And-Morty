package albuquerque.rickandmorty.main;

import albuquerque.rickandmorty.main.controllers.CharacterController;
import albuquerque.rickandmorty.main.menu.Menu;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Menu mainMenu = new Menu();
        int option = 1;
        mainMenu.show();
        while (option != 6) {
            String userInput = scanner.nextLine();
            option = Integer.parseInt(userInput);
            mainMenu.select(option);
        }
        System.out.println("Finalizando app.");

    }
}
