package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> msgs = new ArrayList<>();
        BlockingQueue<String> msgs_enviadas = new ArrayBlockingQueue<>(10);

        msgs.add("Oi");
        msgs.add("Fala");
        msgs.add("Joia");
        msgs.add("Mensagem");
        msgs.add("Responda!");

        System.out.println("Qual o tempo da simulação em segundos?");
        long tempo = scan.nextLong();

        new Thread(){
            public void run(){
                int check_counter = 0;

                while (true) {
                    try {
                        System.out.println("Recebendo : " + msgs_enviadas.take());
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

            }
        }.start();

        // Essa vai ser a thread que escholhe a msg
        new Thread(){
            public void run(){
                int msg_counter = 0;
                String msg_atual = "";

                while (true){
                    Random rand = new Random();
                    long intervalo_msg = rand.nextLong(3000);
                    int msg_index = rand.nextInt(5);
                    msg_counter++;

                    try {
                        Thread.sleep(intervalo_msg);
                        msg_atual = msgs.get(msg_index);
                        msgs_enviadas.add(msg_atual); // adicionando msg pra estrutura
                        System.out.println(msg_counter + "a msg enviada!\n");
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }


            }
        }.start();




        try {
            Thread.sleep(tempo * 1000);
            System.exit(0);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}