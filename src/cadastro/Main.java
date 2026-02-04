package cadastro;

import javax.swing.*;
import java.io.*;
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
        while (escolha <= 0 || escolha > 5){
            System.out.println("=========================Digite=========================");
            System.out.println("1. Cadastrar um novo pet");
            System.out.println("2. Alterar os dados do pet cadastrado");
            System.out.println("3. Deletar um pet cadastrado");
            System.out.println("4. Listar todos os pets cadastrados");
            System.out.println("5. Listar pets por algum critério (idade, nome, raça)");
            System.out.println("Sair");
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
                    while ((linha = leitor.readLine()) != null){
                        System.out.println(linha);
                    }

                }catch (IOException e){
                    e.printStackTrace();
                }
                break;
        }

    }
}
