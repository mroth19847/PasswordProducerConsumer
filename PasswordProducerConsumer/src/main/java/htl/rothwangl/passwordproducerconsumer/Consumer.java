package htl.rothwangl.passwordproducerconsumer;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Consumer implements Runnable{

    private ArrayList<Password> queue;

    public Consumer(ArrayList<Password> queue) {
        this.queue = queue;
    }
    
    @Override
    public void run() {
        while(true){
            synchronized(queue){
                Password pw = queue.get(0);
                queue.remove(pw);
                try {
                    BufferedReader br = new BufferedReader(new FileReader("passwords.txt"));
                    String line = br.readLine();
                    boolean found = false;
                    while(line != null){
                        if(pw.check(line)){
                            found = true;
                            break;
                        }
                        line = br.readLine();
                    }
                    if(found) System.out.println("PW found!");
                    else System.out.println("PW not found!");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

}
