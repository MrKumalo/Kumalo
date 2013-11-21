package is.ru.ttt;

public class IllegalPlayerOptionException extends Exception {
    
     public IllegalPlayerOptionException() {
  		
    }

    public IllegalPlayerOptionException(String message) {
        
        super(message);
    }
}