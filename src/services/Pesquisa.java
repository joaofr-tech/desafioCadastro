package services;

import model.Pet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.BufferOverflowException;
import java.util.ArrayList;
import java.util.List;

public class Pesquisa {
    public File[] buscarFiltros(String tipoPet, String nomePet, String sexoPet, Integer idadePet, Float pesoPet, String racaPet, String enderecoPet) {

        File pasta = new File("petsCadastrados");
        File[] files = pasta.listFiles();

        if (files == null || files.length == 0) {
            System.out.println("Nenhum pet cadastrado ainda.");
            return new File[0];  // Retorna array vazio ao invés de null
        }

        File[] filesMatch = new File[files.length];
        int contador = 0;

        for (File file : files) {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {

                // Ler todas as linhas primeiro
                String[] linhas = new String[7];
                for (int i = 0; i < 7; i++) {
                    linhas[i] = br.readLine();
                }

                // ★ VALIDAÇÃO: Verificar se o arquivo tem linhas suficientes
                if (linhas[0] == null || linhas[1] == null) {
                    System.out.println("Arquivo inválido ou corrompido: " + file.getName());
                    continue;  // Pula este arquivo
                }

                String tipoDoArquivo = linhas[1].replaceAll("^\\d+ - ", "");
                boolean bateTipo = tipoDoArquivo.equalsIgnoreCase(tipoPet);

                boolean bateNome = true;
                if (nomePet != null && linhas[0] != null) {
                    String nomeDoArquivo = linhas[0].replaceAll("^\\d+ - ", "");
                    bateNome = nomeDoArquivo.toLowerCase().contains(nomePet.toLowerCase());
                }

                boolean bateSexo = true;
                if (sexoPet != null && linhas[2] != null) {
                    String sexoDoArquivo = linhas[2].replaceAll("^\\d+ - ", "");
                    bateSexo = sexoDoArquivo.equalsIgnoreCase(sexoPet);
                }

                boolean bateIdade = true;
                if (idadePet != null && linhas[4] != null) {
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
                if (pesoPet != null && linhas[5] != null) {
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
                if (racaPet != null && linhas[6] != null) {
                    String racaDoArquivo = linhas[6].replaceAll("^\\d+ - ", "");
                    bateRaca = racaDoArquivo.toLowerCase().contains(racaPet.toLowerCase());
                }

                boolean bateEndereco = true;
                if (enderecoPet != null && linhas[3] != null) {
                    String enderecoDoArquivo = linhas[3].replaceAll("^\\d+ - ", "");
                    bateEndereco = enderecoDoArquivo.toLowerCase().contains(enderecoPet.toLowerCase());
                }

                if (bateTipo && bateNome && bateSexo && bateIdade && batePeso && bateRaca && bateEndereco) {
                    filesMatch[contador] = file;
                    contador++;

                    // Formatar e imprimir (com verificação de null)
                    String nome = linhas[0] != null ? linhas[0].replaceAll("^\\d+ - ", "") : "N/A";
                    String tipo = linhas[1] != null ? linhas[1].replaceAll("^\\d+ - ", "") : "N/A";
                    String sexo = linhas[2] != null ? linhas[2].replaceAll("^\\d+ - ", "") : "N/A";
                    String endereco = linhas[3] != null ? linhas[3].replaceAll("^\\d+ - ", "") : "N/A";
                    String idade = linhas[4] != null ? linhas[4].replaceAll("^\\d+ - ", "") : "N/A";
                    String peso = linhas[5] != null ? linhas[5].replaceAll("^\\d+ - ", "") : "N/A";
                    String raca = linhas[6] != null ? linhas[6].replaceAll("^\\d+ - ", "") : "N/A";

                    System.out.println(contador + ". " + nome + " - " + tipo + " - " +
                            sexo + " - " + endereco + " - " + idade + " - " +
                            peso + " - " + raca);
                }

            } catch (IOException e) {
                System.out.println("Erro ao ler arquivo: " + file.getName());
                e.printStackTrace();
            }
        }

        if (contador == 0) {
            System.out.println("Nenhum pet encontrado.");
            return new File[0];  // Retorna array vazio ao invés de null
        }

        File[] resultadoFinal = new File[contador];
        for (int i = 0; i < contador; i++) {
            resultadoFinal[i] = filesMatch[i];
        }

        return resultadoFinal;
    }
}
