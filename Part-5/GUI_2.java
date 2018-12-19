import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Scanner;
import java.util.Vector;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.JTextComponent;

//GUI designed by Wishy Parikh.
//Netid: wparik2



/* 
*		Input: For input, there are 7 buttons and one textfield area.
    	User must type the commands like "North", "Brass key".etc in textfield
    	corresponding to that button. 
    	For example for input 'GO NORTH', type 'NORTH in textfield area and then
    	pressed GO. By doing this, the result is updated in output screen.
    	
    	*/



public class GUI_2  implements ActionListener, UserInterface
{
	

	 private String getData;   
 
	 private static JTextArea area;
	 private int Flag;
	 private JFrame GUI_Frame;
	 JTextField temp = new  JTextField();
	 
	 // Default constructor creates the GUI.
	public GUI_2() 
	{
		Flag = 0;	
		getData= "temp";
		
		
		JButton option1 = new JButton("LOOK");
        JButton option2 = new JButton("INVENTORY");
        JButton option3 = new JButton("EXIT");
        
        option1.addActionListener(this);
        option2.addActionListener(this);
        option3.addActionListener(this);

        ButtonGroup group = new ButtonGroup();
        group.add(option1);
        group.add(option2);
        group.add(option3);
        
      String button1 = "GET";
      String button2 = "GO";
      String button3 = "USE";
      String button4 = "DROP";

		GUI_Frame = new JFrame ();              
		
		Panel p1,p2, p3;
		p1= new Panel ( new GridLayout ( 5,2, 5,5));
		p2 = new Panel  ( new FlowLayout ( FlowLayout.LEFT, 5,5));
	
		GUI_Frame.setLayout ( new GridLayout (1,1));
		

		
		JLabel output;
		JButton b;

		GUI_Frame.add((p1));
		
		 Font bigFont = temp.getFont().deriveFont(Font.CENTER_BASELINE, 42);
         temp.setFont(bigFont);
		p1.add(temp);
		
		ButtonGroup group1 = new ButtonGroup();
		p3 = new Panel  ( new FlowLayout ( FlowLayout.LEFT, 5,5));
		
			b= new JButton ( button1);
			b.addActionListener(this);		
			group1.add(b);
			p3.add(b);
			
			b= new JButton ( button2);
			b.addActionListener(this);		
			group1.add(b);
			p3.add(b);
			
			b= new JButton ( button3);
			b.addActionListener(this);		
			group1.add(b);
			p3.add(b);
			
			b= new JButton ( button4);
			b.addActionListener(this);		
			group1.add(b);
			p3.add(b);
			
		p1.add(p3);
		p3.add (option1 );
		p3.add (option2 );
		p3.add (option3 );
		
		
		output= new JLabel ("Output");
		output.setFont(new Font("TimesRoman", Font.CENTER_BASELINE, 26));

		 area= new JTextArea(20, 60);
		p2.add(area);
		
	
		
		p2.add((output));
		GUI_Frame.add((p2));
		GUI_Frame.setSize (400, 640);
		GUI_Frame.setVisible (true);
		GUI_Frame.setTitle ("Player");
		
	
		
	
		
		GUI_Frame.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent we)
			{
				System.exit(0);
				
			}
		});
		
		
	}
	

    


	// Updates the output in GUI.
	public void display(String output) 
	{
	
		area.append(output);

	
		
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

		// TODO Auto-generated method stub

	}





	@Override
	public void actionPerformed(ActionEvent ae) 
	{
		// TODO Auto-generated method stub
		String button=ae.getActionCommand();
		getData = button + " " + temp.getText();
		
		Flag =1;
	
		
	}
	
	
	public void playerName ( Character me)
	{
		GUI_Frame.setTitle(me.getName());
	}
	
	public void cleartext()
	{
		area.setText("");
	}

}
