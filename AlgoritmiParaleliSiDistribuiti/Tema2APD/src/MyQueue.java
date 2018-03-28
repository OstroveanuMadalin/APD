import java.util.LinkedList;
import java.util.Queue;

public class MyQueue {
    private int queueSize=10;
    private Queue<Integer> coada = new LinkedList<>();
    Semaphore semFree= new Semaphore(queueSize);
    Semaphore semFull= new Semaphore(0);

    //MyQueue(int dimensiuneCoada) {

      //  queueSize = dimensiuneCoada;

    //}

    public synchronized void adauga(int element) throws InterruptedException
    {
       // while (coada.size() == queueSize) {
           // System.out.println("Nu se mai pot produce elemente, coada este plina");
           // wait();
       // }

        System.out.println("Am produs elementul " + element);
        semFree.down();
        coada.add(element);
        semFull.up();
        //notify();
    }

    public synchronized void scoate() throws InterruptedException{

       // while(coada.size()==0) {
           // System.out.println("Nu se mai pot consuma elemente, coada este goala");
           // wait();

       // }
        semFull.down();
        int elem=coada.remove();
        semFree.up();
        System.out.println("Am consumat elementul:" +elem);
        //notify();

    }
}