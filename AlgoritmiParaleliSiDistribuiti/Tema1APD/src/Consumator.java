
public class Consumator extends Thread {


    @Override
    public void run (){

        int val=0;
        while (true){
            try {
                ProducatorConsumator.coada.scoate(val);
                System.out.println("Am consumat elemntul " + val);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
