package htl.rothwangl.passwordproducerconsumer;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Password {

    private String password;
    private static ArrayList<String> passwordList = new ArrayList<>();
    
    public boolean check(){
        return false;
    }
    
    public static void createPasswordList(String filename) throws Exception{
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line = reader.readLine();
            while(line != null){
                passwordList.add(line);
            }
        } catch (FileNotFoundException ex) {
            throw new Exception("File not Found!");
        }
    }
}
