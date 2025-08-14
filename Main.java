import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.printf("-- Sistema Download --\n");
        System.out.printf("Digite o tamanho(MB) do arquivo: ");
        double tam = scanner.nextDouble();

        System.out.printf("Digite a quantidade de partes: ");
        int partes = scanner.nextInt();

        System.out.printf("Digite o velocidade de dowload minima: ");
        double velocidade_minima = scanner.nextDouble();

        System.out.printf("Digite o velocidade de dowload maxima: ");
        double velocidade_maxima = scanner.nextDouble();

        double tamanho_download = tam / partes;

        for (int i = 1; i <= partes; i++){
            double speed = velocidade_minima + (velocidade_maxima - velocidade_minima) * Math.random();
            Thread thread = new Thread(new Downloader(speed, tamanho_download));
            thread.start();
        }
        
    }
}