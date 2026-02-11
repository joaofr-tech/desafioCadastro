package services;

import model.Pet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.BufferOverflowException;

public class Pesquisa {
    public void buscarNome(String nomePet){
        File pasta = new File("petsCadastrados");
        File[] files = pasta.listFiles();

        int i = 0;
        for (File file: files){
            try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))){
                String linha = bufferedReader.readLine();
                if (linha.toLowerCase().contains(nomePet.toLowerCase())){
                    i++;
                    System.out.print(i+". "+linha.replaceAll("^.{4}", "")+" ");

                    while ((linha = bufferedReader.readLine()) != null){
                        System.out.print(linha.replaceAll("^\\d", "")+" ");
                    }
                    System.out.println();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
    public void buscarSexo(String sexoPet){
        File pasta = new File("petsCadastrados");
        File[] files = pasta.listFiles();

        int i = 0;
        int j = 0;

        for (File file: files){
            try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))){

                String[] linhas = new String[7];
                String linha;
                while ((linha = bufferedReader.readLine()) != null){
                    linhas[i] = linha;
                    i++;
                }

                if (linhas[2].contains(sexoPet.toUpperCase())){
                    j++;
                    System.out.print(j+". "+linhas[0].replaceAll("^.{4}", "")+" ");

                    for (int k = 1; k <= 6; k++) {
                        System.out.print(linhas[k].replaceAll("^\\d", "")+" ");
                    }
                    System.out.println();
                }
                i = 0;
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
    public void buscarIdade(int idadePet){
        File pasta = new File("petsCadastrados");
        File[] files = pasta.listFiles();

        int i = 0;
        int j = 0;

        for (File file: files) {
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
                String[] linhas = new String[7];
                String linha;

                while ((linha = bufferedReader.readLine()) != null) {
                    linhas[i] = linha;
                    i++;
                }

                String idade = linhas[4].substring(4, linhas[4].length() - 5);
                int idadeComparacao = Integer.parseInt(idade);
                if (idadeComparacao == idadePet) {
                    j++;
                    System.out.print(j + ". " + linhas[0].replaceAll("^.{4}", "") + " ");

                    for (int k = 1; k <= 6; k++) {
                        System.out.print(linhas[k].replaceAll("^\\d", "") + " ");
                    }
                    System.out.println();
                }
                i = 0;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void buscarPeso(float pesoPet){
        File pasta = new File("petsCadastrados");
        File[] files = pasta.listFiles();

        int i = 0;
        int j = 0;

        for (File file: files) {
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
                String[] linhas = new String[7];
                String linha;

                while ((linha = bufferedReader.readLine()) != null) {
                    linhas[i] = linha;
                    i++;
                }

                String peso = linhas[5].substring(4, linhas[4].length() - 3);
                float pesoComparacao = Float.parseFloat(peso);
                if (pesoComparacao == pesoPet) {
                    j++;
                    System.out.print(j + ". " + linhas[0].replaceAll("^.{4}", "") + " ");

                    for (int k = 1; k <= 6; k++) {
                        System.out.print(linhas[k].replaceAll("^\\d", "") + " ");
                    }
                    System.out.println();
                }
                i = 0;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void buscarRaca(String racaPet){
        File pasta = new File("petsCadastrados");
        File[] files = pasta.listFiles();

        int i = 0;
        int j = 0;

        for (File file: files) {
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
                String[] linhas = new String[7];
                String linha;

                while ((linha = bufferedReader.readLine()) != null) {
                    linhas[i] = linha;
                    i++;
                }

                String raca = linhas[6];

                if (raca.toLowerCase().contains(racaPet.toLowerCase())) {
                    j++;
                    System.out.print(j + ". " + linhas[0].replaceAll("^.{4}", "") + " ");

                    for (int k = 1; k <= 6; k++) {
                        System.out.print(linhas[k].replaceAll("^\\d", "") + " ");
                    }
                    System.out.println();
                }
                i = 0;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void buscarEndereco(String enderecoPet){
        File pasta = new File("petsCadastrados");
        File[] files = pasta.listFiles();

        int i = 0;
        int j = 0;

        for (File file: files) {
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
                String[] linhas = new String[7];
                String linha;

                while ((linha = bufferedReader.readLine()) != null) {
                    linhas[i] = linha;
                    i++;
                }

                String endereco = linhas[3];

                if (endereco.toLowerCase().contains(enderecoPet.toLowerCase())) {
                    j++;
                    System.out.print(j + ". " + linhas[0].replaceAll("^.{4}", "") + " ");

                    for (int k = 1; k <= 6; k++) {
                        System.out.print(linhas[k].replaceAll("^\\d", "") + " ");
                    }
                    System.out.println();
                }
                i = 0;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
