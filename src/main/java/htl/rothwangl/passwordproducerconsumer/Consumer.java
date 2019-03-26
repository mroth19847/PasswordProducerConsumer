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
                    System.out.println(Thread.currentThread().getName()+": Password \"" + pw.getPassword() + "\" is in work. Queue size: " + queue.size());
                } else {
                    System.out.println(Thread.currentThread().getName()+": Queue is empty, waiting for producers!");
                    try {
                        queue.notifyAll();

                        queue.wait();
                        continue;
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            
            if (findPW(pw)) {
                System.out.println(Thread.currentThread().getName()+": PW was found!");
            } else {
                System.out.println(Thread.currentThread().getName()+": PW was not found!");
            }
        }
    }

    private boolean findPW(Password pw) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("D:\\Projekte\\Java\\PasswordConsumerProducer_Repository\\src\\main\\java\\htl\\rothwangl\\passwordproducerconsumer\\passwords.txt"));
            String line = "";
            boolean found = false;
            while ((line = br.readLine()) != null) {
                if (pw.check(line)) {
                    found = true;
                    break;
                }
            }
            return found;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
