package main;

import model.Pet;
import services.BuscarPet;
import services.CadastrarPet;
import services.PrintarMenu;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int  escolha = 0;

        PrintarMenu printarMenu = new PrintarMenu();
        CadastrarPet cadastrarPet = new CadastrarPet();
        BuscarPet buscarPet = new BuscarPet();

        while (escolha <= 0 || escolha > 5){
            printarMenu.executar();
            System.out.print(": ");
            escolha = scanner.nextInt();
        }
        switch (escolha) {
            case 1:
                cadastrarPet.executar();
                break;
            case 2:
                buscarPet.executar();
                break;
        }

    }
}
