package htl.rothwangl.passwordproducerconsumer;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProducerConsumer implements Runnable{

    private ArrayList<String> queue;

    public ProducerConsumer(ArrayList<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while(true){
            synchronized (queue){
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    Logger.getLogger(ProducerConsumer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    
}
