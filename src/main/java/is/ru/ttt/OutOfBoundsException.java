/**
 * @(#)OutOfBoundsException.java 1, 18 Nov 2013
 *
 * Copyright (c) arnars12, axelg12, gadidjah12, gunnarsa12, haraldurs12, solberg12 
 */
package is.ru.ttt;

public class OutOfBoundsException extends Exception {

	/**
	 * This exception is thrown if the location in a table is not within certain range.
	 * @param  message 	Error message.
	 * @return         	Message.
	 */
    public OutOfBoundsException(String message) {
        
        super(message);
    }
}
