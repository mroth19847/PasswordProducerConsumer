package htl.rothwangl.passwordproducerconsumer;

import java.util.ArrayList;

public class Consumer implements Runnable{

    private ArrayList<Password> queue;

    public Consumer(ArrayList<Password> queue) {
        this.queue = queue;
    }
    
    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
