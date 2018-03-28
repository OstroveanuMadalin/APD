public class ProducatorConsumator {
    public static MyQueue coada = new MyQueue();

    public static void main(String args[]) throws InterruptedException {

        Producator producator = new Producator();
        Consumator consumator = new Consumator();

        producator.start();
        consumator.start();


        producator.join();
        consumator.join();

    }
}