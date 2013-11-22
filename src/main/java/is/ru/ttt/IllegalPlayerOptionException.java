/**
 * @(#)IllegalPlayerOptionException.java 1, 18 Nov 2013
 *
 * Copyright (c) arnars12, axelg12, gadidjah12, gunnarsa12, haraldurs12, solberg12 
 */
package is.ru.ttt;

public class IllegalPlayerOptionException extends Exception {
    
    /**
	 * This exception is thrown when a player enters an invalid input
	 * @param  message 	Error message.
	 * @return         	Message.
	 */

    public IllegalPlayerOptionException(String message) {
        
        super(message);
    }
}