import java.util.Scanner;

public class Text_Interface implements UserInterface
{
	public void display(String output) 
	{
		// TODO Auto-generated method stub
		
		// Need two different ways of system out.
		
	//	System.out.println( "Display enter");
		System.out.println(output);
		 
		 
		
	}

	@Override
	public String getLine() 
	{
		System.out.println( "Get line enter");
		Scanner input = new Scanner(System.in);
		String userInput = input.nextLine();
		return userInput;
	}
	
	public void playerName ( Character me)
	{
		return;
		//myFrame.setTitle(me.getName());
	}
	
	public void cleartext()
	{
		return;
	}
	
	
}
