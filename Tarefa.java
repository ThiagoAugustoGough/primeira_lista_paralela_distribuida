public class Tarefa implements Runnable{
    public String descricao;
    public int duracao;

    Tarefa(String descricao, int duracao) {
        this.descricao = descricao;
        this.duracao = duracao;
    }

    @Override
    public void run() {
        System.out.println("Thread : " + Thread.currentThread().threadId() + " Executando");

        try {
            Thread.sleep(this.duracao);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(this.descricao + " Terminou de processar");

    }
}
