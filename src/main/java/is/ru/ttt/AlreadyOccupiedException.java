/**
 * @(#)AlreadyOccupiedException.java 1, 18 Nov 2013
 *
 * Copyright (c) arnars12, axelg12, gadidjah12, gunnarsa12, haraldurs12, solberg12 
 */
package is.ru.ttt;

public class AlreadyOccupiedException extends Exception 
{

	/**
	 * This exception is thrown when a cell on the board is already occupied.
	 * @param  message 	Error message.
	 * @return         	Message.
	 */

    public AlreadyOccupiedException(String message) 
    {
        
        super(message);
    }
}