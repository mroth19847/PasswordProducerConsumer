package htl.rothwangl.passwordproducerconsumer;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Password> queue = new ArrayList<>();

        Producer p1 = new Producer(queue);
        Consumer c1 = new Consumer(queue);
        Producer p2 = new Producer(queue);
        Consumer c2 = new Consumer(queue);
        Producer p3 = new Producer(queue);
        Consumer c3 = new Consumer(queue);

        new Thread(c1, "Consumer 1").start();
        new Thread(c2, "Consumer 2").start();
        new Thread(c3, "Consumer 3").start();
        new Thread(p1, "Producer 1").start();
        new Thread(p2, "Producer 2").start();
        new Thread(p3, "Producer 3").start();

    }

}
