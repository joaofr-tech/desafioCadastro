package services;

import java.io.*;
import java.util.Scanner;
import static services.AlterarLinha.alterarLinha;

public class  AlterarPet {
    public static void executar(){
        BuscarPet bp = new BuscarPet();
        Scanner scanner = new Scanner(System.in);
        File pasta = new File("petsCadastrados");
        File[] files = pasta.listFiles();

        if (files == null || files.length == 0) {
            System.out.println("Nenhum arquivo encontrado na pasta.");
            return;
        }

        File[] file = bp.executar();

        if (file == null) {
            System.out.println("buscarFiltros retornou NULL");
            return;
        }

        System.out.println("Qual pet deseja alterar: ");
        int petAlteracao = scanner.nextInt();

        System.out.println("1. Nome");
        System.out.println("2. Endereco");
        System.out.println("3. Idade");
        System.out.println("4. Peso");
        System.out.println("5. Raca");
        System.out.print("o que deseja trocar: ");
        int escolhaTroca = scanner.nextInt();
        scanner.nextLine();

        switch (escolhaTroca){
            case 1:
                System.out.print("Novo nome: ");
                String novoNome = scanner.nextLine();
                alterarLinha(file[petAlteracao - 1], 0, "1 - "+novoNome);
                break;
            case 2:
                System.out.print("Novo endereco: ");
                String novoEndereco = scanner.nextLine();
                alterarLinha(file[petAlteracao - 1], 1, "4 - "+novoEndereco);
                break;
            case 3:
                System.out.print("Nova idade: ");
                String novaIdade = scanner.nextLine();
                alterarLinha(file[petAlteracao - 1], 2, "5 - "+novaIdade);
                break;
            case 4:
                System.out.print("Novo peso: ");
                String novoPeso = scanner.nextLine();
                alterarLinha(file[petAlteracao - 1], 3, "6. "+novoPeso);
                break;
            case 5:
                System.out.print("Nova raca: ");
                String novaRaca = scanner.nextLine();
                alterarLinha(file[petAlteracao - 1], 4, "7. "+novaRaca);
                break;
            default:
                System.out.println("Opcao invalida!");
        }
    }
}