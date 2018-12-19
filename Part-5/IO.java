
public class IO implements UserInterface
{
	static final int TEXT= 0;
	static final int GUI_1= 1;
	static final int  GUI_2= 2;
	static final int  GUI_3= 3;
	private int set =0;
    UserInterface t1;


	@Override
	public void display(String output) 
	{
		// TODO Auto-generated method stub
		
	//	System.out.println(output);
		
		t1.display(output);
		
		
	}
	
	
	@Override
	public String getLine() 
	{
		//String input = null
		return t1.getLine();

	}
	

	public void playerName ( Character me)
	{
		t1.playerName (me);
		
	}
	
	public void selectInterface ( int select)
	{
		System.out.println("Your user interface number:  " + select);
	//	// Multiple if else to select interfaces.
		if (select ==  TEXT)
		{
			set = TEXT;
			t1 = new Text_Interface();
			
		}  
		
		 if (select ==  GUI_1)
		{
			set = TEXT;
			
             t1 = new GUI_1 ();
		}
		
		else if (select ==  GUI_2)
		{
			set = TEXT;
            t1 = new GUI_2 ();
		}
		
		else if (select ==   GUI_3)
		{
			set = TEXT;
            t1 = new GUI_3 ();
		}
		 
		 
		 
		
	}
	
	
	public void cleartext()
	{
		t1.cleartext();
	}
	
}
