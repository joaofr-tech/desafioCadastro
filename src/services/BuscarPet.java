package services;

import model.Pet;

import java.io.File;
import java.util.Scanner;

public class BuscarPet{
    public void executar() {
        Pet pet2 = new Pet();
        Scanner scanner = new Scanner(System.in);
        // Tipo
        System.out.print("Tipo: ");
        String criterioTipo = scanner.nextLine();

        boolean nomePetValido = false;

        while(!nomePetValido) {
            try {
                pet2.tipo = Pet.Tipo.valueOf(criterioTipo.toUpperCase());
                nomePetValido = true;
            } catch (IllegalArgumentException e) {
                System.out.println("Digite cachorro ou gato!");
                System.out.print("Tipo: ");
                criterioTipo = scanner.nextLine();
            }
        }

        // Criterio
        System.out.println("Criterio de busca: ");
        System.out.println("1 - Nome ou sobrenome ");
        System.out.println("2 - Sexo ");
        System.out.println("3 - Idade ");
        System.out.println("4 - Peso ");
        System.out.println("5 - Raça ");
        System.out.println("6 - Endereço ");


        System.out.print("Criterio 1: ");
        int criterioDeEscolha1 = scanner.nextInt();
        scanner.nextLine();

        Pesquisa pesquisa = new Pesquisa();
        switch (criterioDeEscolha1){
            // nome
            case 1:
                System.out.print("Nome: ");
                String nome = scanner.nextLine();
                pesquisa.buscarNome(nome);
                break;

            // Sexo
            case 2:
                System.out.print("Sexo: ");
                String sexo = scanner.nextLine();
                pesquisa.buscarSexo(sexo);
                break;

            // Idade
            case 3:
                System.out.print("Idade: ");
                int idade = scanner.nextInt();
                pesquisa.buscarIdade(idade);
                break;

            // Peso
            case 4:
                System.out.print("Peso: ");
                float peso = scanner.nextFloat();
                pesquisa.buscarPeso(peso);
                break;

            // Raca
            case 5:
                System.out.print("Raca: ");
                String raca = scanner.nextLine();
                break;

            // Endereco
            case 6:
                break;
        }
    }
}
