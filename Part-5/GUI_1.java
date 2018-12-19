import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Scanner;
import java.util.Vector;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.JTextComponent;

// GUI designed by Nemil Shah.
// Netid: nshah213


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
		
 
 * 
 *----------------------------------THANK YOU--------------------------------------------------*/



public class GUI_1  implements ActionListener, UserInterface
{
	 private String getData;  // Returns the data to  the getLine function.
     private static ArrayList<JTextField >  textfield= new ArrayList < JTextField > (4);   // Four textfields for four different commands.
	 private static JTextArea area;  // Output Textbox area.
	 private int Flag;
	 private JFrame myFrame;    // Creation of my frame.
	 private static String buttonText;  // String of button .
	 
	
	// Default constructor creates the GUI.
	public GUI_1() 
	{
		// Initiliaze.
		Flag = 0;	
		getData= "xxx";
		buttonText= "null";
		
		// Frame.....................................................................................................
		
		myFrame = new JFrame ();              // My GUI FRAME CREATED!!!!!!!!!!!
		myFrame.setLayout ( new GridLayout (2,2));
		myFrame.setSize (400, 640);
		myFrame.setVisible ( true);
		myFrame.setTitle ("Player");
		
		// Labels.....................................................................................................
		
		JLabel in, io;
		
		in= new JLabel ("Input", SwingConstants.CENTER);
		in.setFont(new Font("Serif", Font.CENTER_BASELINE, 36));
		in.setForeground(Color.RED);
		
	      // create a line border with the specified color and width
		 Border border = BorderFactory.createLineBorder(Color.DARK_GRAY, 1);
		 in.setBorder(border);
		 
		 io= new JLabel ("Output", SwingConstants.CENTER);
		 io.setFont(new Font("Serif", Font.CENTER_BASELINE, 36));
		io.setForeground(Color.RED);
		     // create a line border with the specified color and width
		Border border2 = BorderFactory.createLineBorder(Color.DARK_GRAY, 1);
		io.setBorder(border2);
		
		// Buttons......................................................................................................
		
		String [] buttonLabels = { "GO", "GET", "DROP", "USE"};
		Button b;

		JRadioButton option1 = new JRadioButton("LOOK");
        JRadioButton option2 = new JRadioButton("INVENTORY");
        JRadioButton option3 = new JRadioButton("EXIT");
        
        option1.addActionListener(this);
        option2.addActionListener(this);
        option3.addActionListener(this);

        ButtonGroup group = new ButtonGroup();
        group.add(option1);
        group.add(option2);
        group.add(option3);
        
        JRadioButton selectedButton = null;

        
	   // Panels......................................................................................................
	
		Panel p1,p2, p3;
		p1= new Panel ( new GridLayout ( 5,2, 5,5));
		p2 = new Panel  ( new FlowLayout ( FlowLayout.LEFT, 5,5));
		
		
		// Colors......................................................................................................
		
		Color[] c1 = {Color.RED,Color.cyan,Color.GREEN, Color.YELLOW};
		
		
		// Fonts......................................................................................................
		
		Font f1= new Font ("Arial", Font.BOLD,10);

		myFrame.add((in));
		myFrame.add((p1));

		for ( int i= 0; i<4 ; i++)
		{
			b= new Button ( buttonLabels[i]);
			b.setFont(f1);
			JTextField temp = new  JTextField();
			textfield.add( temp);

			b.addActionListener(this);		
			b.setBackground(c1[i]);
			b.setForeground(Color.black);
			b.setSize(3,1);
			p1.add( b);
			p1.add(textfield.get(i));
		}
		
		p3 = new Panel  ( new FlowLayout ( FlowLayout.LEFT, 5,5));
		p1.add(p3);
		p3.add (option1 );
		p3.add (option2 );
		p3.add (option3 );
		

		Border border3 = BorderFactory.createLineBorder(Color.RED, 2);
		io.setBorder(border2);
		 area= new JTextArea(22, 50);
		area.setBorder(border3);
		p2.add(area);

		myFrame.add((io));
		myFrame.add((p2));
		
		myFrame.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent we)
			{
				System.exit(0);
				
			}
		});
		
		
	}
	

    


	// Updates the output in GUI.
	public void display(String output) 
	{

		Font f1= new Font ("Arial", Font.BOLD,13);
		area.append(output);
		area.setFont(f1);;

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
		myFrame.setTitle(me.getName());
	}
	
	public void cleartext()
	{
		area.setText("");
	}

}