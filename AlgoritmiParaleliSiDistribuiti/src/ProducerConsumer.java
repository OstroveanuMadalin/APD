import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumer {

    Queue<Integer> queue= new LinkedList<>();
    int  queueCapacity= 10;

    public void produce() throws  InterruptedException
    {
        int val=0;

        while(true){

            synchronized (this)
            {

                while(queue.size()==queueCapacity){
                    System.out.println("Coada este plina");
                    wait();
                }
                System.out.println("Producatorul a produs:" + val);
                queue.add(val);
                val+=1;
                notify();
                Thread.sleep(500);
            }
        }
    }

    public void consuma() throws InterruptedException
    {

        while(true){

            synchronized (this){

                while(queue.size()==0){
                    System.out.println("Coada este goala");
                    wait();
                }
                int val2= queue.remove();
                System.out.println("Consumatorul a consumat:" +val2 );
                notify();
                Thread.sleep(500);
            }
        }
    }


}
