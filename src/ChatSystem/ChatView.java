package ChatSystem;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Observable;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatView extends JFrame implements ActionListener {

	private JTextField textFieldInput;
	private JTextArea textAreaOutput;
	private JButton buttonSend;
	private JButton buttonQuit;
	 ObjectOutputStream outToServer;
	 ObjectInputStream inFromServer;
	 Socket clientSocket;

	public ChatView()
	{
		super("View");

		initialize();
		addComponentsToFrame();
		
		ObjectOutputStream outToClient;
	   ObjectInputStream inFromClient;
	}

	public void start()
	{
		buttonSend.addActionListener(this);
		buttonQuit.addActionListener(this);
		textFieldInput.addActionListener(this);
		setVisible(true);
		try{
		 final int PORT = 6789;
       final String HOST = "10.52.233.208";
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
		textFieldInput = new JTextField();
		textAreaOutput = new JTextArea();
		textAreaOutput.setEditable(false);
		textAreaOutput.setBackground(Color.WHITE);
		buttonSend = new JButton("Send");
		buttonQuit = new JButton("Quit");
		setSize(350, 150); // set frame size
		setLocationRelativeTo(null); // center of the screen
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		textAreaOutput.setBackground(Color.LIGHT_GRAY);
	}

	private void addComponentsToFrame()
	{
		JPanel panelButtons = new JPanel();
		panelButtons.add(buttonSend);
		panelButtons.add(buttonQuit);

		JPanel panel1 = new JPanel(new BorderLayout());
		panel1.add(textFieldInput, BorderLayout.CENTER);
		panel1.add(panelButtons, BorderLayout.EAST);

		JScrollPane scrollPane = new JScrollPane(textAreaOutput);

		JPanel contentPane = new JPanel(new BorderLayout());
		contentPane.add(panel1, BorderLayout.NORTH);
		contentPane.add(scrollPane, BorderLayout.CENTER);

		setContentPane(contentPane);
	}

	public void UpdateMessages(String message)
	{
	   textAreaOutput.append(message);
	   
	}
	@Override
	// ActionListener
	public void actionPerformed(ActionEvent e)
	{
		if (e.getActionCommand().equals("Send"))
		      
		{
		   
	     

	      try{
	     
	      // create client socket, connect to server.
	      
	    textFieldInput.getText();
	    String s = textFieldInput.getText();
	    Message m=new Message(s);
	    outToServer.writeObject(m);
	    textAreaOutput.append("\n");
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
	}
}

// comment