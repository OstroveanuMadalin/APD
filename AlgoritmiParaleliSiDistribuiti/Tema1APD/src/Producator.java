
public class Producator extends Thread {

    public int val;
    Producator (){
        val=0;
    }
    public int getVal(){
        return val;
    }
    @Override
    public void run() {


        while (true){
            val+=1;
            try {
                ProducatorConsumator.coada.adauga(val);
                System.out.println("Am produs elementul " + val);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
