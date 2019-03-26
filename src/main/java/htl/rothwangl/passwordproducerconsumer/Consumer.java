package htl.rothwangl.passwordproducerconsumer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Consumer implements Runnable {

    private ArrayList<Password> queue;

    public Consumer(ArrayList<Password> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            Password pw = null;
            synchronized (queue) {
                if (queue.size() > 0) {
                    pw = queue.get(0);
                    queue.remove(pw);
                    System.out.println("Password \"" + pw.getPassword() + "\" is in work. Queue size: " + queue.size());
                } else {
                    System.out.println("Queue is empty, waiting for producers!");
                    try {
                        queue.wait();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            if(findPW(pw)){
                System.out.println("PW was found!");
            } else {
                System.out.println("PW was not found!");
            }
        }
    }

    private boolean findPW(Password pw) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("passwords.txt"));
            String line = br.readLine();
            boolean found = false;
            while (line != null) {
                if (pw.check(line)) {
                    found = true;
                    break;
                }
                line = br.readLine();
            }
            return found;
        } catch (Exception ex) {
            System.out.println("File not found!");
            return false;
        }
    }
}
