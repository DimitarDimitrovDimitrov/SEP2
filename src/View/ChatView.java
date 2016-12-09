package View;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Observable;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

import ChatSystem.Client;
import ChatSystem.ClientReciever;
import Controller.ClientController;
import Controller.Controller;
import Model.Message;

import java.util.GregorianCalendar;

public class ChatView extends JFrame implements ActionListener,View {
private JButton setName;
   private JTextField userNameField;
	private JTextField textFieldInput;
	private JTextArea textAreaOutput;
	
	private JButton buttonSend;
	private JButton buttonQuit;
	
	
Client c;



ClientController controller;


	public ChatView()
	{
	   
		super("View");

		initialize();
		addComponentsToFrame();
		
		c=new Client();
		ObjectOutputStream outToClient;
	   ObjectInputStream inFromClient;
	   
	   //send a message with the enter 
	   textFieldInput.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent event)
         {
            controller.sendMessageEnter(event.getActionCommand());
          
            
         }
      }
);
	   
	}
	
	
	

	public void start (ClientController controller)
	{
	   
	   
		
		this.controller=controller;

		
		setVisible(true);
		
	}


	private void initialize()
	{
	   userNameField=new JTextField(10);
	   //userNameField.setEditable(true);
		textFieldInput = new JTextField();
		textAreaOutput = new JTextArea();
		textAreaOutput.setEditable(false);
		textAreaOutput.setBackground(Color.WHITE);
		// adding setname button
		setName=new JButton("Set");
		
		buttonSend = new JButton("Send");
		buttonQuit = new JButton("Quit");
		
		buttonQuit.addActionListener(this);

		
		setSize(500,350); // set frame size
		setLocationRelativeTo(null); // center of the screen
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		textAreaOutput.setBackground(Color.LIGHT_GRAY);
		
		
		
		
		
	}
	
	public JTextField TextFieldInput()
   {
      return textFieldInput;
   }
	public String getTextFieldInput()
   {
      return textFieldInput.getText();
   }
	public void setTextFieldInput()
	{
	   this.textFieldInput.setText("");;
	}
	public String getUserNameField()
   {
      return userNameField.getText();
   }
	

	private void addComponentsToFrame()
	{
	   // adding the username to the gui
	   JPanel top = new JPanel();
	  
	   top.add(new JLabel("Your name: "));
	 
	   top.add(userNameField);
	   top.add(setName);
	   
		JPanel panelButtons = new JPanel();
		panelButtons.add(buttonSend);
		panelButtons.add(buttonQuit);

		JPanel panel1 = new JPanel(new BorderLayout());		
		
		

		
		
		panel1.add(textFieldInput, BorderLayout.CENTER);
		panel1.add(panelButtons, BorderLayout.EAST);

		JScrollPane scrollPane = new JScrollPane(textAreaOutput);
		

		JPanel contentPane = new JPanel(new BorderLayout());
		contentPane.add(top,BorderLayout.SOUTH);
		contentPane.add(panel1, BorderLayout.NORTH);
		contentPane.add(scrollPane, BorderLayout.CENTER);
  
		setContentPane(contentPane);
	}

	public void UpdateMessages(String message)
	{
	   
	   textAreaOutput.append("\n"+  ""+message);
	   
	}
	
	
	
	// ActionListener
	
	
	public void actionPerformed(ActionEvent e)
	{
	   
  controller.actionPerformed(e);	
	}




  




   




   




   
	
}
// comment