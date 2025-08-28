import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Main {
    public static void main(String[] args) {
        List<Tarefa> lista_tarefas = new ArrayList<>();
        Scanner scan = new Scanner(System.in);



        // Popular lista de tarefas

        Tarefa t1 = new Tarefa("Primeira Tarefa", 1400);
        Tarefa t2 = new Tarefa("Segunda Tarefa", 7800);
        Tarefa t3 = new Tarefa("Terceira Tarefa", 800);
        Tarefa t4 = new Tarefa("Quarta Tarefa", 5400);
        Tarefa t5 = new Tarefa("Quinta Tarefa", 3032);

        lista_tarefas.add(t1);
        lista_tarefas.add(t2);
        lista_tarefas.add(t3);
        lista_tarefas.add(t4);
        lista_tarefas.add(t5);

        System.out.println("Digite o numero maximo de tarefas paralelas : ");
        int num_maximo = scan.nextInt();

        ExecutorService executorService = Executors.newFixedThreadPool(num_maximo);

        for (Tarefa tarefa : lista_tarefas) {
            executorService.submit(tarefa);
        }

        executorService.shutdown();

    }
}