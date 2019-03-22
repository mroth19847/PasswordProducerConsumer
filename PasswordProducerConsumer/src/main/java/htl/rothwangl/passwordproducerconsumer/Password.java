package htl.rothwangl.passwordproducerconsumer;

public class Password {

    private String password;
    
    public boolean check(String test){
        return test.equals(password);
    }
}
