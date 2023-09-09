package legendSoft.exception;

public class BadCredentialsException extends RuntimeException{

    public BadCredentialsException(){

    }

    public BadCredentialsException(String massage){
        super(massage);
    }
}
