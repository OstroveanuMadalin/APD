
public class Consumator extends Thread {

    @Override
    public void run (){


        while (true){
            try {

                ProducatorConsumator.coada.scoate();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}