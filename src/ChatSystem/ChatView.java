package ChatSystem;
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

import java.util.GregorianCalendar;
public class ChatView extends JFrame implements ActionListener {
private JButton setName;
   private JTextField userNameField;
	private JTextField textFieldInput;
	private JTextArea textAreaOutput;
	
	private JButton buttonSend;
	private JButton buttonQuit;
	
	 ObjectOutputStream outToServer;
	 ObjectInputStream inFromServer;
	 Socket clientSocket;
Client c;


	public ChatView()
	{
	   
		super("View");

		initialize();
		addComponentsToFrame();
		
		c=new Client();
		ObjectOutputStream outToClient;
	   ObjectInputStream inFromClient;
	}
	
	
	

	public void start()
	{
	   
	   setName.addActionListener(this);
		buttonSend.addActionListener(this);
		buttonQuit.addActionListener(this);
		textFieldInput.addActionListener(this);
		userNameField.addActionListener(this);
		setVisible(true);
		try{
		 final int PORT = 6789;
       final String HOST = "10.52.234.82";
		 clientSocket = new Socket(HOST, PORT);
		// create input stream attached to the socket.
		 inFromServer = new ObjectInputStream(clientSocket.getInputStream());
		// create output stream attached to the socket.
       outToServer = new ObjectOutputStream(clientSocket.getOutputStream());
       String existing = textAreaOutput.getText();
       textAreaOutput.setText(existing+"\n"+"Client> connected to server");
       ClientReciever r=new ClientReciever(inFromServer,this);
       new Thread(r,"Reciever").start();
       
       
        
        
        
        

		}
		catch (IOException ex)
		{
		   System.out.println("ERROR");
		   ex.printStackTrace();
		   
		}
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
		setSize(350, 150); // set frame size
		setLocationRelativeTo(null); // center of the screen
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		textAreaOutput.setBackground(Color.LIGHT_GRAY);
		
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
	@Override
	// ActionListener
	
	
	public void actionPerformed(ActionEvent e)
	{
	   
		if (e.getActionCommand().equals("Send"))
		      
		{
		   
	     

	      try{
	     
	      // create client socket, connect to server.
	         String  timeStamp=new SimpleDateFormat("HH.mm.ss").format(new java.util.Date());
	    textFieldInput.getText();
	    String s =  "["+ timeStamp+"] "+ userNameField.getText()+": "+textFieldInput.getText();
	    Message m=new Message(s);
	   
	    outToServer.writeObject(m);
	    
	    
	    textFieldInput.setText("");
	    
	      }
	      catch(Exception ex)
	      {
	         
	      }
	      
		}
		else if(e.getActionCommand().equals("Quit"))
		{
			System.exit(0);
			System.out.println("code");
		}
		 if(e.getActionCommand().equals("Set"))
		{
		   String name=userNameField.getText();
		   c.setName(name);
		}
	}
}

// comment