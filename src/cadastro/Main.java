package cadastro;

import javax.lang.model.util.SimpleTypeVisitor14;
import javax.swing.*;
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
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
                FileReader formulario;
                try {
                    formulario = new FileReader("C:\\Users\\João\\OneDrive\\Desktop\\Projetos\\desafioCadastro\\src\\cadastro\\formulario.txt");
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
                try (BufferedReader leitor = new BufferedReader(formulario)) {

                    String linha;
                    int i = 0;
                    Scanner scanner = new Scanner(System.in);

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
                                boolean nomePetValido = false;

                                while (!nomePetValido){
                                    try {
                                        pet1.tipo = Pet.Tipo.valueOf(resposta.toUpperCase());
                                        nomePetValido = true;
                                    }catch(IllegalArgumentException e){
                                        System.out.println("Digite cachorro ou gato!");
                                        System.out.println(linha);
                                        resposta = scanner.nextLine();
                                    }
                                }
;

                                break;

                            case 2:
                                boolean sexoPetValido = false;

                                while (!sexoPetValido){
                                    try{
                                        pet1.sexo = Pet.Sexo.valueOf(resposta.toUpperCase());
                                        sexoPetValido = true;
                                    }catch(IllegalArgumentException e){
                                        System.out.println("Digite Femea ou Macho!");
                                        System.out.println(linha);
                                        resposta = scanner.nextLine();
                                    }
                                }
                                break;

                            case 3:
                                System.out.print("Numero da Casa: ");
                                pet1.endereco.numeroDaCasa = scanner.nextLine();
                                if (pet1.endereco.numeroDaCasa.isEmpty()){
                                    pet1.endereco.numeroDaCasa = Pet.enderecoNumeroNaoInformado;
                                }

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
                                if(pet1.idade > 20){
                                    throw new IllegalArgumentException("Digite uma idade menor que 20!");
                                }
                                break;

                            case 5:
                                try{
                                    pet1.peso = Float.parseFloat(resposta);
                                }catch (NumberFormatException e){
                                    throw new NumberFormatException("Digite um numero no peso!");
                                }

                                if (pet1.peso > 60 || pet1.peso < 0.5){
                                    throw new IllegalArgumentException("Digite um peso valido!");
                                }

                                break;
                            case 6:
                                pet1.raca = resposta;

                                if (!(pet1.raca.matches("^[a-zA-z]+$"))){
                                    throw new IllegalArgumentException("Sem numeros ou caracteres especiais!");
                                }

                                break;
                        }
                        i++;
                    }

                }catch (IOException e){
                    e.printStackTrace();
                }
                LocalDateTime agora = LocalDateTime.now();
                DateTimeFormatter formatador = DateTimeFormatter.ofPattern("yyyyMMdd'T'HHmm");
                String dataFormatada = agora.format(formatador);

                File pasta = new File("petsCadastrados");
                if(!pasta.exists()){
                    pasta.mkdir();
                }

                File file = new File(pasta, dataFormatada+"-"+pet1.nome.replace(" ", "").toUpperCase()+".txt");

                try {
                    file.createNewFile();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                try (BufferedWriter escrever = new BufferedWriter(new FileWriter(file))) {
                    escrever.write("1 - " + pet1.nome);
                    escrever.newLine();
                    escrever.write("2 - " + pet1.tipo);
                    escrever.newLine();
                    escrever.write("3 - " + pet1.sexo);
                    escrever.newLine();
                    escrever.write("4 - " + pet1.endereco.rua+", "+pet1.endereco.numeroDaCasa+", "+pet1.endereco.cidade);
                    escrever.newLine();
                    escrever.write("5 - " + pet1.idade+" anos");
                    escrever.newLine();
                    escrever.write("6 - " + pet1.peso+ "kg");
                    escrever.newLine();
                    escrever.write("7 - " + pet1.raca);

                } catch (IOException e) {
                    e.printStackTrace();
                }
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
