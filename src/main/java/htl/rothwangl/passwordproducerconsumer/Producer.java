package htl.rothwangl.passwordproducerconsumer;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Producer implements Runnable {

    private ArrayList<Password> queue;

    public Producer(ArrayList<Password> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (queue) {
                if (queue.size() < 5) {
                    Scanner scn = new Scanner(System.in);
                    System.out.print("Please input Password: ");
                    String pw = scn.next();
                    queue.add(new Password(pw));
                    queue.notifyAll();
                    System.out.println("Password \"" + pw + "\" was added to the queue! Queue size: " + queue.size());
                } else {
                    try {
                        queue.wait();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }
        }
    }

}
