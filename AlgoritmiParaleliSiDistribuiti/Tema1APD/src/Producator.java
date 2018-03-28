public class Producator extends Thread {

    public static  int val=0;
    Object obj= new Object();


    @Override 
    public void run() {


        while (true){

            try {
               int tmp;
                synchronized (obj) {
                    tmp = val;
                    val++;
                    }
                ProducatorConsumator.coada.adauga(tmp);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
