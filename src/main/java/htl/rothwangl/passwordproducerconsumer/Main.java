package htl.rothwangl.passwordproducerconsumer;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Password> queue = new ArrayList<>();
        
        Producer p1 = new Producer(queue);
        Consumer c1 = new Consumer(queue);
        
        new Thread(c1, "Consumer 1").start();
        new Thread(p1, "Producer 1").start();
    }

}
