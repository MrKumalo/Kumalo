package is.ru.ttt;

public class IllegalTurnException extends Exception {
    
     public IllegalTurnException() {
  		
    }

    public IllegalTurnException(String message) {
        
        super(message);
    }
}