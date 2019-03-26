package htl.rothwangl.passwordproducerconsumer;

public class Password {

    private String password;

    public Password(String password) {
        this.password = password;
    }
    
    public boolean check(String test){
        return test.equals(password);
    }

    public String getPassword() {
        return password;
    }
    
    
}
