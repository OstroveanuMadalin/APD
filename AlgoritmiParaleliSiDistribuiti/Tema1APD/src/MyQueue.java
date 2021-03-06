import java.util.LinkedList;
import java.util.Queue;

public class MyQueue {
    private int queueSize;
    private Queue<Integer> coada = new LinkedList<>();

    MyQueue(int dimensiuneCoada) {

        queueSize = dimensiuneCoada;

    }

    public synchronized void adauga(int element) throws InterruptedException
    {
        while (coada.size() == queueSize) {
            System.out.println("Nu se mai pot produce elemente, coada este plina");
            wait();
        }
        System.out.println("Am produs elementul " + element);
        coada.add(element);
        notify();
    }

    public synchronized void scoate() throws InterruptedException{

        while(coada.size()==0) {
            System.out.println("Nu se mai pot consuma elemente, coada este goala");
            wait();

        }
        int elem=coada.remove();
        System.out.println("Am consumat elementul:" +elem);
        notify();

    }
}