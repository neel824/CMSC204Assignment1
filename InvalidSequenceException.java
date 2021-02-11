
/**
 * 
 * Throws when more than 2 characters in a row
 *
 */
public class InvalidSequenceException extends Exception
{
	public InvalidSequenceException() 
	{
		super("The password cannot contain more than two of the same character in sequence");
	}
}
