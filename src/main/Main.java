package main;

import model.Pet;
import services.CadastrarPet;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int escolha = 0;
        Scanner scan = new Scanner(System.in);
        Pet pet1 = new Pet();

        while (escolha <= 0 || escolha > 5){
            System.out.println("=========================MENU=========================");
            System.out.println("1. Cadastrar um novo pet");
            System.out.println("2. Buscar pet cadastrado");
            System.out.println("3. Alterar dados de um pet");
            System.out.println("4. Deletar pet cadastrado");
            System.out.println("5. Sair");
            escolha = scan.nextInt();
        }
        switch (escolha) {
            case 1:
                CadastrarPet cadastrarPet = new CadastrarPet();
                cadastrarPet.executar();
                break;
            case 2:
                Pet pet2 = new Pet();
                System.out.println("Qual criterio de busca: ");
                System.out.println("1 - Nome ou sobrenome ");
                System.out.println("2 - Sexo ");
                System.out.println("3 - Idade ");
                System.out.println("4 - Peso ");
                System.out.println("5 - Raça ");
                System.out.println("6 - Endereço ");

                System.out.print("Criterio(s): ");
                int criterioDeEscolha = scan.nextInt();
                scan.nextLine();

                System.out.print("Tipo: ");
                String criterioTipo = scan.nextLine();

                boolean nomePetValido = false;

                while (!nomePetValido){
                    try {
                        pet2.tipo = Pet.Tipo.valueOf(criterioTipo.toUpperCase());
                        nomePetValido = true;
                    }catch(IllegalArgumentException e){
                        System.out.println("Digite cachorro ou gato!");
                        System.out.print("Tipo: ");
                        criterioTipo = scan.nextLine();
                    }
                }

                break;
        }

    }
}
