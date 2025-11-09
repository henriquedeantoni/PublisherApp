package gui.util;

import java.io.FileWriter;
import java.io.IOException;

public class ExportFilesCSV {
    // Exporta uma matriz 2D para um arquivo CSV
    public static void exportMatrixToCsv(int[][] matrix, String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            for (int[] row : matrix) {
                for (int j = 0; j < row.length; j++) {
                    writer.write(String.valueOf(row[j]));
                    if (j < row.length - 1) {
                        writer.write(",");
                    }
                }
                writer.write("\n");
            }
            System.out.println("Arquivo CSV da matriz criado com sucesso!");
        } catch (IOException e) {
            System.err.println("Erro ao escrever o arquivo CSV: " + e.getMessage());
        }
    }

    // Exporta um vetor 1D para um arquivo CSV
    public static void exportVectorToCsv(int[] vector, String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            for (int i = 0; i < vector.length; i++) {
                writer.write(String.valueOf(vector[i]));
                if (i < vector.length - 1) {
                    writer.write(",");
                }
            }
            writer.write("\n");
            System.out.println("Arquivo CSV do vetor criado com sucesso!");
        } catch (IOException e) {
            System.err.println("Erro ao escrever o arquivo CSV: " + e.getMessage());
        }
    }

}
