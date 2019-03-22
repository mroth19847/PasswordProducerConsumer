package htl.rothwangl.passwordproducerconsumer;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProducerConsumer implements Runnable{

    private ArrayList<Password> queue;

    public ProducerConsumer(ArrayList<Password> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while(true){
            synchronized (queue){
                Scanner scn = new Scanner(System.in);
                System.out.println("Please input Password: ");
                String pw = scn.next();
                queue.add(new Password(pw));
            }
        }
    }
    
    
}
