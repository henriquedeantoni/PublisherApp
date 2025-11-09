package gui.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class CombAndConsts {

    public static final int N = 60; // intervalo 1..60

    public List<int[]> comb3;
    public List<int[]> comb4;
    
    // Conveniência: gera todas combinações de 3 números (1..60)
    public List<int[]> generateAllComb3() {
        return generateAllCombinations(N, 3);
    }

    // Conveniência: gera todas combinações de 4 números (1..60)
    public List<int[]> generateAllComb4() {
        return generateAllCombinations(N, 4);
    }

    public CombAndConsts() {
    	comb3 = generateAllComb3();
    	comb4 = generateAllComb4();
    }
    
    /**
     * Gera todas as combinações de k elementos do conjunto {1..n}.
     * Retorna uma List onde cada elemento é um int[] com comprimento k.
     * Atenção: para n=60, k=4 o total é 487.635 combinações.
     */
    public List<int[]> generateAllCombinations(int n, int k) {
        List<int[]> result = new ArrayList<>();
        int[] current = new int[k];
        backtrack(n, k, 1, 0, current, result);
        return result;
    }

    // Backtracking recursivo para gerar combinações
    private void backtrack(int n, int k, int start, int depth, int[] current, List<int[]> result) {
        if (depth == k) {
            // copia do array atual
            int[] comb = new int[k];
            System.arraycopy(current, 0, comb, 0, k);
            result.add(comb);
            return;
        }
        // poda: ainda precisa preencher (k - depth) posições,
        // o último valor possível é n - (k - depth) + 1
        for (int val = start; val <= n - (k - depth) + 1; val++) {
            current[depth] = val;
            backtrack(n, k, val + 1, depth + 1, current, result);
        }
    }

    /**
     * Iterador que gera combinações lexicograficamente sem armazenar todas.
     * Cada combinação retornada é um int[] (copiado antes de retornar).
     *
     * Uso:
     *   CombinationIterator it = new CombinationIterator(60,4);
     *   while(it.hasNext()) { int[] comb = it.next(); ... }
     */
    public static class CombinationIterator implements Iterator<int[]> {
        private final int n;
        private final int k;
        private final int[] current;
        private boolean hasNext;

        public CombinationIterator(int n, int k) {
            if (k < 0 || k > n) throw new IllegalArgumentException("k must be 0..n");
            this.n = n;
            this.k = k;
            this.current = new int[k];
            if (k == 0) {
                hasNext = false;
            } else {
                // inicializa com [1,2,...,k]
                for (int i = 0; i < k; i++) current[i] = i + 1;
                hasNext = k <= n;
            }
        }

        @Override
        public boolean hasNext() {
            return hasNext;
        }

        @Override
        public int[] next() {
            if (!hasNext) throw new NoSuchElementException();
            // retorna cópia do current
            int[] ret = new int[k];
            System.arraycopy(current, 0, ret, 0, k);

            // gera próximo lexicográfico
            int i = k - 1;
            while (i >= 0 && current[i] == n - (k - 1 - i)) {
                i--;
            }
            if (i < 0) {
                hasNext = false; // acabado
            } else {
                current[i]++;
                for (int j = i + 1; j < k; j++) {
                    current[j] = current[j - 1] + 1;
                }
            }
            return ret;
        }
    }

    /**
     * Exemplo: grava todas combinações (n,k) em CSV (cada linha: valores separados por vírgula),
     * usando o iterator (sem carregar tudo em memória).
     */
    public void writeCombinationsToCsv(int n, int k, String filePath) throws IOException {
        CombinationIterator it = new CombinationIterator(n, k);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            while (it.hasNext()) {
                int[] comb = it.next();
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < comb.length; i++) {
                    sb.append(comb[i]);
                    if (i < comb.length - 1) sb.append(',');
                }
                bw.write(sb.toString());
                bw.newLine();
            }
        }
    }

    /*
    // Exemplo de uso
    public static void main(String[] args) {
        CombAndConsts util = new CombAndConsts();

        // 1) Gerar todas em memória (cuidado com memória para grandes valores)
        System.out.println("Gerando todas combinações C(60,3) em memória...");
        List<int[]> all3 = util.generateAllComb3();
        System.out.println("Total C(60,3) = " + all3.size());

        // 2) Usar iterator para processar/printar sem guardar tudo
        System.out.println("Iterando C(60,4) com CombinationIterator (apenas imprimindo as 10 primeiras)...");
        CombinationIterator it = new CombinationIterator(60, 4);
        int count = 0;
        while (it.hasNext() && count < 10) {
            int[] comb = it.next();
            StringBuilder sb = new StringBuilder();
            for (int v : comb) sb.append(v).append(' ');
            System.out.println(sb.toString().trim());
            count++;
        }

        // 3) Exemplo de gravação em arquivo (descomente para usar)
        /*
        try {
            System.out.println("Gravando C(60,4) em arquivo combos60x4.csv ...");
            util.writeCombinationsToCsv(60, 4, "combos60x4.csv");
            System.out.println("Gravação finalizada.");
        } catch (IOException e) {
            e.printStackTrace();
        }
      }
    */
}

