import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.*;
public class MyQueue {
    private int queueSize;
    private Queue<Integer> coada = new LinkedList<>();
   private final Lock lock = new ReentrantLock();

    MyQueue(int dimensiuneCoada) {

       queueSize = dimensiuneCoada;

    }

    public synchronized void adauga(int element)  {

    try {
        if(coada.size() == queueSize) {
            lock.lock();
        }
    }
    finally {
        System.out.println("Am produs elementul " + element);
        coada.add(element);
        lock.unlock();
    }

    }

    public synchronized void scoate() {
        try{
            if(coada.size()==0){
                lock.lock();
            }
        }
        finally {
             int item = coada.remove();
             System.out.println("Am consumat elementul " + item);
             lock.unlock();
         }
    }
}