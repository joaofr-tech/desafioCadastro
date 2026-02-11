package services;

import java.util.Scanner;

public class AlterarPet {
    public static void executar(){
        BuscarPet bp = new BuscarPet();
        Scanner scanner= new Scanner(System.in);

        bp.executar();
        System.out.println("Qual pet deseja alterar: ");
        int petAlteracao = scanner.nextInt();
    }
}
