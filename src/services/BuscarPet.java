package services;

import model.Pet;

import java.io.File;
import java.util.Scanner;

public class BuscarPet{
    public void executar() {
        Pet pet2 = new Pet();
        Scanner scanner = new Scanner(System.in);

        String tipo = null;
        String nome = null;
        String sexo = null;
        Integer idade = null;
        Float peso = null;
        String raca = null;
        String endereco = null;

        System.out.print("Tipo: ");
        String criterioTipo = scanner.nextLine();

        boolean nomePetValido = false;

        while(!nomePetValido) {
            try {
                pet2.tipo = Pet.Tipo.valueOf(criterioTipo.toUpperCase());
                tipo = criterioTipo;
                nomePetValido = true;
            } catch (IllegalArgumentException e) {
                System.out.println("Digite cachorro ou gato!");
                System.out.print("Tipo: ");
                criterioTipo = scanner.nextLine();
            }
        }

        // Criterio
        int criterioDeEscolha1 = 0;
        do {
            System.out.println("Criterio de busca: ");
            System.out.println("1 - Nome ou sobrenome ");
            System.out.println("2 - Sexo ");
            System.out.println("3 - Idade ");
            System.out.println("4 - Peso ");
            System.out.println("5 - Raça ");
            System.out.println("6 - Endereço ");

            System.out.print("Criterio 1: ");
            criterioDeEscolha1 = scanner.nextInt();
            scanner.nextLine();
        } while (criterioDeEscolha1 > 6 || criterioDeEscolha1 < 1);

        switch (criterioDeEscolha1){
            // nome
            case 1:
                System.out.print("Nome: ");
                nome = scanner.nextLine();
                break;

            // Sexo
            case 2:
                System.out.print("Sexo: ");
                sexo = scanner.nextLine();
                break;

            // Idade
            case 3:
                System.out.print("Idade: ");
                idade = scanner.nextInt();
                break;

            // Peso
            case 4:
                System.out.print("Peso: ");
                peso = scanner.nextFloat();
                break;

            // Raca
            case 5:
                System.out.print("Raca: ");
                raca = scanner.nextLine();
                break;

            // Endereco
            case 6:
                System.out.print("Endereco: ");
                endereco = scanner.nextLine();
                break;
        }
            System.out.print("Deseja segundo critério? (S/N): ");
            String respostaCriterio2 = scanner.nextLine();

        if (respostaCriterio2.equalsIgnoreCase("S")) {
            int criterioDeEscolha2 = 0;
            do {
                System.out.print("Criterio 2 (Diferente de " + criterioDeEscolha1 + "): ");
                criterioDeEscolha2 = scanner.nextInt();
                scanner.nextLine();
            } while (criterioDeEscolha2 > 6 || criterioDeEscolha2 < 1);

            switch (criterioDeEscolha2) {
                case 1:
                    if (nome == null) {
                        System.out.print("Nome: ");
                        nome = scanner.nextLine();
                    }
                    break;
                case 2:
                    if (sexo == null) {
                        System.out.print("Sexo: ");
                        sexo = scanner.nextLine();
                    }
                    break;
                case 3:
                    if (idade == null) {
                        System.out.print("Idade: ");
                        idade = scanner.nextInt();
                    }
                    break;

                // Peso
                case 4:
                    if (peso == null) {
                        System.out.print("Peso: ");
                        peso = scanner.nextFloat();
                    }
                    break;

                // Raca
                case 5:
                    if (raca == null) {
                        System.out.print("Raca: ");
                        raca = scanner.nextLine();
                    }
                    break;

                // Endereco
                case 6:
                    if (endereco == null) {
                        System.out.print("Endereco: ");
                        endereco = scanner.nextLine();
                    }
                    break;
            }
        }
        Pesquisa pesquisa = new Pesquisa();
        pesquisa.buscarFiltros(tipo, nome, sexo, idade, peso, raca, endereco);
    }
}
