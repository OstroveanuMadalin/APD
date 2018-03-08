public class ProdCons {

    public static void main(String[] arg) throws InterruptedException
    {
        ProducerConsumer pc= new ProducerConsumer();

        Thread t1= new Thread(new Runnable() {
            @Override
            public void run() {
                try
                {
                    pc.produce();
                }

                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        });


        Thread t2= new Thread(new Runnable() {
            @Override
            public void run() {
                try
                {
                    pc.consuma();
                }

                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }

}
