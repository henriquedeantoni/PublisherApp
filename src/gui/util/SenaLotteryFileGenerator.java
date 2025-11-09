package gui.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SenaLotteryFileGenerator {
    
	/**
     * Gera todas as combinações possíveis da Mega-Sena e salva em um arquivo CSV.
     * @param path Caminho completo do arquivo de saída (ex: "C:/dados/megasena.csv")
     * @throws IOException Se ocorrer erro de escrita
     */

    public static void genarateToFile(String path) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path+"\\sena-combs.csv"))) {
            int[] atual = new int[6];
            recursiveGenerator(writer, atual, 0, 1);
        }
    }

    private static void recursiveGenerator(BufferedWriter writer, int[] atual, int pos, int inicio) throws IOException {
        if (pos == 6) {
            writer.write(String.format("%d,%d,%d,%d,%d,%d\n",
                atual[0], atual[1], atual[2], atual[3], atual[4], atual[5]));
            return;
        }
        for (int i = inicio; i <= 60 - (6 - pos) + 1; i++) {
            atual[pos] = i;
            recursiveGenerator(writer, atual, pos + 1, i + 1);
        }
    }
    
    public static int[][] readCombinationsFromFile(String path) throws IOException {
        List<int[]> linhas = new ArrayList<>();

        File file = new File(path);

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(",");
                if (partes.length == 6) {
                    int[] numeros = new int[6];
                    for (int i = 0; i < 6; i++) {
                        numeros[i] = Integer.parseInt(partes[i].trim());
                    }
                    linhas.add(numeros);
                }
            }
        }

        int[][] matriz = new int[linhas.size()][6];
        for (int i = 0; i < linhas.size(); i++) {
            matriz[i] = linhas.get(i);
        }

        System.out.println("Matriz carregada com " + matriz.length + " linhas.");
        return matriz;
    }
}
