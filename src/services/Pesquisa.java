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
    public void buscarFiltros(String tipoPet, String nomePet, String sexoPet, Integer idadePet, Float pesoPet, String racaPet, String enderecoPet) {

        File pasta = new File("petsCadastrados");
        File[] files = pasta.listFiles();

        if (files == null || files.length == 0) {
            System.out.println("Nenhum pet cadastrado ainda.");
            return;
        }

        int contador = 0;

        for (File file : files) {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {

                String[] linhas = new String[7];
                for (int i = 0; i < 7; i++) {
                    linhas[i] = br.readLine();
                }

                String tipoDoArquivo = linhas[1].replaceAll("^\\d+ - ", "");
                boolean bateTipo = tipoDoArquivo.equalsIgnoreCase(tipoPet);

                boolean bateNome = true;  // default
                if (nomePet != null) {
                    String nomeDoArquivo = linhas[0].replaceAll("^\\d+ - ", "");
                    bateNome = nomeDoArquivo.toLowerCase().contains(nomePet.toLowerCase());
                }

                boolean bateSexo = true;
                if (sexoPet != null) {
                    String sexoDoArquivo = linhas[2].replaceAll("^\\d+ - ", "");
                    bateSexo = sexoDoArquivo.equalsIgnoreCase(sexoPet);
                }

                boolean bateIdade = true;
                if (idadePet != null) {
                    String idadeDoArquivo = linhas[4].replaceAll("^\\d+ - ", "")
                            .replace(" anos", "")
                            .trim();

                    if (!idadeDoArquivo.equals("NÃO INFORMADO")) {
                        try {
                            int idadeArquivo = Integer.parseInt(idadeDoArquivo);
                            bateIdade = (idadeArquivo == idadePet);
                        } catch (NumberFormatException e) {
                            bateIdade = false;
                        }
                    } else {
                        bateIdade = false;
                    }
                }

                boolean batePeso = true;
                if (pesoPet != null) {
                    String pesoDoArquivo = linhas[5]
                            .replaceAll("^\\d+ - ", "")
                            .replace("kg", "")
                            .trim();

                    if (!pesoDoArquivo.equals("NÃO INFORMADO")) {
                        try {
                            float pesoArquivo = Float.parseFloat(pesoDoArquivo);
                            batePeso = (pesoArquivo == pesoPet);
                        } catch (NumberFormatException e) {
                            batePeso = false;
                        }
                    } else {
                        batePeso = false;
                    }
                }

                boolean bateRaca = true;
                if (racaPet != null) {
                    String racaDoArquivo = linhas[6].replaceAll("^\\d+ - ", "");
                    bateRaca = racaDoArquivo.toLowerCase().contains(racaPet.toLowerCase());
                }

                boolean bateEndereco = true;
                if (enderecoPet != null) {
                    String enderecoDoArquivo = linhas[3].replaceAll("^\\d+ - ", "");
                    bateEndereco = enderecoDoArquivo.toLowerCase().contains(enderecoPet.toLowerCase());
                }


                if (bateTipo && bateNome && bateSexo && bateIdade && batePeso && bateRaca && bateEndereco) {
                    contador++;

                    // Formatar e imprimir
                    String nome = linhas[0].replaceAll("^\\d+ - ", "");
                    String tipo = linhas[1].replaceAll("^\\d+ - ", "");
                    String sexo = linhas[2].replaceAll("^\\d+ - ", "");
                    String endereco = linhas[3].replaceAll("^\\d+ - ", "");
                    String idade = linhas[4].replaceAll("^\\d+ - ", "");
                    String peso = linhas[5].replaceAll("^\\d+ - ", "");
                    String raca = linhas[6].replaceAll("^\\d+ - ", "");

                    System.out.println(contador + ". " + nome + " - " + tipo + " - " +
                            sexo + " - " + endereco + " - " + idade + " - " +
                            peso + " - " + raca);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (contador == 0) {
            System.out.println("Nenhum pet encontrado.");
        }
    }
}
