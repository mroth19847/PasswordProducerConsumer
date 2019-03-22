package htl.rothwangl.passwordproducerconsumer;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Password {

    private String password;
    
    public boolean check(String test){
        return test.equals(password);
    }
}
