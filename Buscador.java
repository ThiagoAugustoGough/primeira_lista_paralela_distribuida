class Buscador extends Thread {
    private String blocoTexto;
    private String palavraBusca;
    private int idBloco;
    private int contador = 0;

    public Buscador(String blocoTexto, String palavraBusca, int idBloco) {
        this.blocoTexto = blocoTexto.toLowerCase();
        this.palavraBusca = palavraBusca.toLowerCase();
        this.idBloco = idBloco;
    }

    @Override
    public void run() {
        String[] palavrasDoBloco = this.blocoTexto.split("\\s+");
        for (String palavra : palavrasDoBloco) {

            if (palavra.contains(this.palavraBusca)) {
                contador++;
            }
        }
        System.out.printf("Thread %d (Bloco %d) encontrou %d ocorrências.\n", this.getId(), this.idBloco, contador);
    }

    public int getContador() {
        return contador;
    }
}