import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//GUI designed by Harshil Patel.
//Netid: hpate86


/*----------------------------------HEADER-------------------------------------------------- 
*		 GUI contains two parts. Upper Part as Input and lower part as Output.

		Input: For input, there are four buttons, 3 radio buttons and four textfield areas.
    	User must type the commands like "North", "Brass key".etc in textfield
    	corresponding to that button. 
    	For example for input 'GO NORTH', type 'NORTH in textfield area and then
    	pressed GO. By doing this, the result is updated in output screen.
    	
    	For look, inventory and exit, just clicked on either of the buttons.

		Output: For output, there is one big textboxarea. It contains intial current information,
     prompt message for making move, and lastly the result output after move.
    

		Designs: Frame is GridLayout Design implemented by use of buttons,panels,labels etc.
		
		Note: Please don't try to do multiple inputs for one single move because it won't work properly after that. Be very precise in
		       doing the input. For example, typing beside the GET button, and pressing on USE button, then it will be messed up.
		
		NOTEEEE: Please switch to full screen to see the FULL GUI
* 
*----------------------------------THANK YOU--------------------------------------------------*/


public class GUI_3  implements ActionListener, UserInterface
{
	
	 private int Flag;
	 private JFrame newFrame;
	 private static String buttonText;
	 private JTextArea inputArea;
	 private String getData;   
     private static ArrayList<JTextField >  textfield= new ArrayList < JTextField > (4); 
	 private static JTextArea area;

	 
	public GUI_3() 
	{
		getData= "xxx";
		setButtonText("null");
		Flag = 0;	
		Panel x,y, z;
		x= new Panel ( new GridLayout ( 5,2, 5,5));
		y = new Panel  ( new FlowLayout ( FlowLayout.LEFT, 5,5));
		
		newFrame = new JFrame ();   
		newFrame.getContentPane().setBackground(Color.BLACK);
		newFrame.setVisible ( true);
		newFrame.setTitle ("Player");
		newFrame.setSize (800, 800); //Switch to full screen to see full GUI
		newFrame.setLayout(new GridLayout());
		
		Button b1 = new Button("LOOK");
        Button b2 = new Button("INVENTORY");
        Button b3 = new Button("EXIT");
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);

        new ButtonGroup();
        x.add(b1);
        x.add(b2);
        x.add(b3);
        
        String [] buttonLabels = { "GO", "GET", "DROP", "USE"};
		  
		Button b;
		
		z = new Panel  ( new FlowLayout ( FlowLayout.LEFT, 5,5));
		for ( int i= 0; i<4 ; i++)
		{
			b= new Button ( buttonLabels[i]);
			JTextField temp = new  JTextField();
			
			textfield.add( temp);
			b.addActionListener(this);		
			b.setBackground(Color.blue);
			b.setForeground(Color.black);
			//b.setSize(3,1);
			x.add( b);
			x.add(textfield.get(i));
		}
		newFrame.add((x));
		x.add(z);	
		
		z.add (b1 );
		z.add (b2 );
		z.add (b3 );
		
		 area= new JTextArea(40, 60);
		 area.setBackground(Color.cyan);
		 y.add(area);
		 newFrame.add(y);
		 
		 newFrame.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent we)
			{
				System.exit(0);
				
			}
		});	
	}

	// Updates the output in GUI.
	public void display(String output) 
	{
	//	area.setText( output);
		   
		//area.insert(output, 0);
		area.append(output);

	//	 System.out.println(" Welcome to GUI_1 interface");
		
	}

	// Takes the input action done in GUI.
	public String getLine()
	{
		while(true)
		{
			System.out.print("");
			
			if(Flag == 1)
			{
				System.out.println(" ");
				Flag = 0;
				//System.out.println();
				return getData;
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent ae) 
	{
		// TODO Auto-generated method stub
		String button=ae.getActionCommand();

		System.out.println("Name of button: " + button);
		
		for ( int i=0; i < textfield.size(); i++)
		{
			  if(!(textfield.get(i).getText().isEmpty()))
			  {
					System.out.println("TextSSSS is  "+  textfield.get(i).getText());
					getData = button + " " + textfield.get(i).getText();
					textfield.get(i).setText("");
					break;
			  }
			  else
			  {
				//	System.out.println("Text is  "+  buttonText);
				    getData = button;
				//    System.out.println("Text is  "+   button);
			  }
		}
		Flag =1;
	}
	
	public void playerName ( Character me)
	{
		newFrame.setTitle(me.getName());
	}
	
	public void cleartext()
	{
		area.setText("");
	}

	public static String getButtonText() {
		return buttonText;
	}

	public static void setButtonText(String buttonText) {
		GUI_3.buttonText = buttonText;
	}

	public JTextArea getInputArea() {
		return inputArea;
	}

	public void setInputArea(JTextArea inputArea) {
		this.inputArea = inputArea;
	}

}
