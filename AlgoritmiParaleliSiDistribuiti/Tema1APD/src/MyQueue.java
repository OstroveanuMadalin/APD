import java.util.LinkedList;
import java.util.Queue;

public class MyQueue {
    private int queueSize;
    private Queue<Integer> coada = new LinkedList<>();

    MyQueue(int dimensiuneCoada) {

        queueSize = dimensiuneCoada;
    }

    public synchronized void adauga(Integer element) throws InterruptedException {

        while (coada.size() == queueSize) {
            System.out.println("Nu se mai pot produce elemente, coada este plina");
            wait();
        }

        coada.add(element);
        notify();
        Thread.sleep(3000);

    }

    public synchronized void scoate(int element) throws InterruptedException{

        while(coada.size()==0) {
            System.out.println("Nu se mai pot consuma elemente, coada este goala");
            wait();
        }
        coada.remove(element);
        notify();
        Thread.sleep(3000);

    }
}