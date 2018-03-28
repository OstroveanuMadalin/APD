public class Semaphore {
    int capacity;

    public Semaphore(int capacity){
        this.capacity = capacity;
    }

    public synchronized void down(){
        while (capacity <= 0){
            try{
                this.wait();
            }catch (InterruptedException e){
            }
        }
        capacity--;
    }

    public synchronized void up(){
        capacity++;
        this.notify();
    }
}