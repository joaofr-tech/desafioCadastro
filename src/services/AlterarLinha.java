package services;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AlterarLinha {
    public static void alterarLinha(File arquivo, int numeroLinha, String novoValor) {
        List<String> linhas = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                linhas.add(linha);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if (linhas.size() > numeroLinha) {
            linhas.set(numeroLinha, novoValor);
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo))) {
            for (String l : linhas) {
                bw.write(l);
                bw.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}