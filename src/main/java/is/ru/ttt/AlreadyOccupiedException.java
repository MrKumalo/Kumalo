/*
* @(#)AlreadyOccupiedException.java 1, 18 Nov 2013
 *
 * Copyright (c) arnars12, axelg12, gadidjah12, gunnarsa12, haraldurs12, solberg12 
 */
package is.ru.ttt;

/**
 * 
 *
 * @author arnars12, axelg12, gadidjah12, gunnarsa12, haraldurs12, solberg12  
 * @version 1, 20 November 2013
 */
public class AlreadyOccupiedException extends Exception 
{
	/**
	 * [AlreadyOccupiedException description]
	 * @param  message [description]
	 * @return         [description]
	 */
    public AlreadyOccupiedException(String message) 
    {
        
        super(message);
    }
}