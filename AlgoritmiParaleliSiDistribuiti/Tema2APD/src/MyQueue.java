import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;
public class MyQueue {
    private int queueSize=10;
    private Queue<Integer> coada = new LinkedList<>();
    Semaphore semFree;
    Semaphore semFull;

    MyQueue(int dimensiuneCoada) {

       queueSize = dimensiuneCoada;
       semFree= new Semaphore(queueSize);
        semFull= new Semaphore(0);

    }

    public synchronized void adauga(int element) throws InterruptedException
    {

        System.out.println("Am produs elementul " + element);
        semFree.acquire();
        coada.add(element);
        semFull.release();
    }

    public synchronized void scoate() throws InterruptedException{

        semFull.acquire();
        int elem=coada.remove();
        semFree.release();
        System.out.println("Am consumat elementul:" +elem);


    }
}