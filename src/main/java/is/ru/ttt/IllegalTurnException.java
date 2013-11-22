/**
 * @(#)IllegalTurnException.java 1, 18 Nov 2013
 *
 * Copyright (c) arnars12, axelg12, gadidjah12, gunnarsa12, haraldurs12, solberg12 
 */
package is.ru.ttt;

public class IllegalTurnException extends Exception {
    
    /**
	 * This exception is thrown when turn is not 1 or 2.
	 * @param  message 	Error message.
	 * @return         	Message.
	 */

    public IllegalTurnException(String message) {
        
        super(message);
    }
}