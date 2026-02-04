package cadastro;

import javax.swing.*;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FileReader formulario;
        try {
            formulario = new FileReader("C:\\Users\\João\\OneDrive\\Desktop\\Projetos\\desafioCadastro\\src\\cadastro\\formulario.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        try (BufferedReader leitor = new BufferedReader(formulario)) {
            String linha;
            while ((linha = leitor.readLine()) != null) {
                System.out.println(linha);
            }
        }catch (IOException e){
            e.printStackTrace();
        }

        int escolha = 0;
        Scanner scan = new Scanner(System.in);
        while (escolha <= 0 || escolha > 6){
            System.out.println("=========================Digite=========================");
            System.out.println("1. Cadastrar um novo pet");
            System.out.println("2. Alterar os dados do pet cadastrado");
            System.out.println("3. Deletar um pet cadastrado");
            System.out.println("4. Listar todos os pets cadastrados");
            System.out.println("5. Listar pets por algum critério (idade, nome, raça)");
            System.out.println("6. Sair");
            escolha = scan.nextInt();
        }
        switch (escolha){
            case 1:
                try {
                    formulario = new FileReader("C:\\Users\\João\\OneDrive\\Desktop\\Projetos\\desafioCadastro\\src\\cadastro\\formulario.txt");
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
                try (BufferedReader leitor = new BufferedReader(formulario)) {

                    String linha;
                    int i = 0;
                    Scanner scanner = new Scanner(System.in);
                    Pet pet1 = new Pet();

                    while((linha = leitor.readLine()) != null){

                        System.out.println(linha);
                        String resposta = "";
                        if (i != 3){
                            resposta = scanner.nextLine();
                        }

                        switch (i){
                            case 0:
                                pet1.nome = resposta;

                                if((pet1.nome).isEmpty()){
                                    throw new IllegalArgumentException("Digite um nome!");
                                }

                                if(!(pet1.nome.matches( "^[a-zA-Z]+\s+[a-zA-Z]+$"))){
                                    throw new IllegalArgumentException("Digite nome e sobrenome! Sem caracteres especiais.");
                                }

                                break;

                            case 1:
                                pet1.tipo = Pet.Tipo.valueOf(resposta.toUpperCase());
                                break;

                            case 2:
                                pet1.sexo = Pet.Sexo.valueOf(resposta.toUpperCase());
                                break;

                            case 3:
                                System.out.print("Numero da Casa: ");
                                pet1.endereco.numeroDaCasa = scanner.nextLine();

                                System.out.print("Cidade: ");
                                pet1.endereco.cidade = scanner.nextLine();

                                System.out.print("Rua: ");
                                pet1.endereco.rua = scanner.nextLine();

                                break;

                            case 4:
                                try{
                                    pet1.idade = Float.parseFloat(resposta);
                                }catch(NumberFormatException e){
                                    throw new NumberFormatException("Digite um numero na idade!");
                                }

                                break;

                            case 5:
                                try{
                                    pet1.peso = Float.parseFloat(resposta);
                                }catch (NumberFormatException e){
                                    throw new NumberFormatException("Digite um numero no peso!");
                                }

                                break;
                            case 6:
                                pet1.raca = resposta;
                        }
                        i++;
                    }

                }catch (IOException e){
                    e.printStackTrace();
                }
                break;
        }
    }
}
