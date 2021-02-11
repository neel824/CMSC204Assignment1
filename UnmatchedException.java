/**
 * 
 * Throws when passwords dont match
 */
public class UnmatchedException extends Exception 
{
	public UnmatchedException()
	{
		super("The passwords do not match");
	}
}
