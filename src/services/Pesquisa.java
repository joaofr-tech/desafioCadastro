package services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Pesquisa {
    public void buscarNome(String nomePet){
        File pasta = new File("petsCadastrados");
        File[] files = pasta.listFiles();

        for (File file: files){
            try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))){
                String linha = bufferedReader.readLine();
                if (linha.toLowerCase().contains(nomePet.toLowerCase())){

                    System.out.print("1. "+linha.replaceAll("^.{4}", "")+" ");

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
}
