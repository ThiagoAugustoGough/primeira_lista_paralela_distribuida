public class Downloader implements Runnable{

    private double download_speed;
    private double download_size;
    private double miliseconds;
    public Downloader(double download_speed, double download_size){

        this.download_speed = download_speed;
        this.download_size = download_size;
    }

@Override
    public void run(){
        System.out.println("Thread " + Thread.currentThread().getId() + "Iniciando Download");
        miliseconds = (download_size / download_speed) * 1000;

    try {
        Thread.sleep((int) miliseconds);
    } catch (InterruptedException e) {
        throw new RuntimeException(e);
    }
    System.out.println("Thread " + Thread.currentThread().getId() + " Terminado Download em : " + miliseconds + " milisegundos!");
    }
}
