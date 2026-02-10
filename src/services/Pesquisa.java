package services;

import model.Pet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

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
}
