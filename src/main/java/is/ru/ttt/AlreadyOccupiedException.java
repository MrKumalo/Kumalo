package is.ru.ttt;

public class AlreadyOccupiedException extends Exception {
    
     public AlreadyOccupiedException() {
  		
    }

    public AlreadyOccupiedException(String message) {
        
        super(message);
    }
}