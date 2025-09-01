import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Scanner scan = new Scanner(System.in);

        System.out.println("Digite o texto:");
        String texto_principal = scan.nextLine();

        System.out.println("Digite a palavra a ser buscada:");
        String palavra_busca = scan.nextLine();

        System.out.println("Digite a quantidade de blocos:");
        int quant_blocos = scan.nextInt();
        scan.nextLine();

        String[] palavras = texto_principal.split("\\s+");

        if (quant_blocos <= 0 || palavras.length < quant_blocos) {
            System.out.println("A quantidade de blocos é inválida ou maior que o número de palavras.");
            return;
        }

        List<String> blocos = new ArrayList<>();
        int palavras_por_bloco = palavras.length / quant_blocos;
        int palavras_sobra = palavras.length % quant_blocos;
        int index_palavra = 0;

        for (int i = 0; i < quant_blocos; i++) {
            StringBuilder bloco = new StringBuilder();
            int num_palavras_bloco = palavras_por_bloco + (i < palavras_sobra ? 1 : 0);

            for (int j = 0; j < num_palavras_bloco; j++) {
                if (bloco.length() > 0) {
                    bloco.append(" ");
                }
                bloco.append(palavras[index_palavra]);
                index_palavra++;
            }
            blocos.add(bloco.toString());
        }

        System.out.println("\nIniciando busca com " + quant_blocos + " threads...");

        List<Buscador> threads = new ArrayList<>();
        for (int i = 0; i < quant_blocos; i++) {
            Buscador buscador = new Buscador(blocos.get(i), palavra_busca, i + 1);
            threads.add(buscador);
            buscador.start();
        }

        int totalOcorrencias = 0;
        for (Buscador buscador : threads) {
            buscador.join();
            totalOcorrencias += buscador.getContador();
        }

        System.out.println("\n--- Busca Finalizada ---");
        System.out.println("Total geral de ocorrências: " + totalOcorrencias);

        scan.close();
    }
}