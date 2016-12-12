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

import ChatSystem.ClientReciever;
import Controller.ClientController;
import Controller.Controller;
import Model.Message;

import java.util.GregorianCalendar;

/**
 *@author Oleg,Dimitar,Todor
 * 
 */
/**
 * this is the class that has all the element for the GUI.
 */
public class ChatView extends JFrame implements ActionListener, View
{
   private JButton setName;
   private JTextField userNameField;
   private JTextField textFieldInput;
   private JTextArea textAreaOutput;
   private JTextArea onlineusersArea;// online users

   private JButton buttonSend;
   private JButton buttonQuit;

   ClientController controller;

   public ChatView()
   {

      super(" View ");

      initialize();
      addComponentsToFrame();

      /**
       * this method sends a message when the enter button is pressed .
       * 
       * 
       * 
       */
      // send a message with the enter
      textFieldInput.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent event)
         {
            controller.sendMessageEnter(event.getActionCommand());

         }
      });

   }

   public void start(ClientController controller)
   {

      this.controller = controller;

      setVisible(true);

   }

   /**
    * initializes all the fields and buttons .
    * 
    * 
    * 
    */
   private void initialize()
   {
      userNameField = new JTextField(10);
      // userNameField.setEditable(true);
      textFieldInput = new JTextField();
      textAreaOutput = new JTextArea();
      textAreaOutput.setEditable(false);
      textAreaOutput.setBackground(Color.WHITE);

      onlineusersArea = new JTextArea(5, 8);// online users
      onlineusersArea.setEditable(false);
      // adding setname button
      setName = new JButton("Set");

      buttonSend = new JButton("Send");
      buttonQuit = new JButton("Quit");

      buttonQuit.addActionListener(this);
      setName.addActionListener(this);

      setSize(500, 350); // set frame size
      setLocationRelativeTo(null); // center of the screen
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      textAreaOutput.setBackground(Color.LIGHT_GRAY);

   }

   /**
    * return the Jtextfield textFieldInput .
    * 
    * @return textFieldInput.
    */
   public JTextField TextFieldInput()
   {
      return textFieldInput;
   }

   /**
    * return the text from the textFieldInput.
    * 
    * @return textFieldInput.getText().
    */
   public String getTextFieldInput()
   {
      return textFieldInput.getText();
   }

   /**
    * sets the textFieldInput to blank.
    */
   public void setTextFieldInput()
   {
      this.textFieldInput.setText("");
   }

   /**
    * get the text from userNameField.
    * 
    * @return userNameFiel.getText();
    */
   public String getUserNameField()
   {
      return userNameField.getText();
   }

   /**
    * adds all the components to the frame.
    * <p>
    * adds all the components to the JPanel.
    * 
    * 
    * @return conns.size();
    */
   private void addComponentsToFrame()
   {
      // adding the username to the gui
      JPanel top = new JPanel();
      // online users pannel

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
      JScrollPane online = new JScrollPane(onlineusersArea);

      JPanel contentPane = new JPanel(new BorderLayout());
      contentPane.add(top, BorderLayout.SOUTH);
      contentPane.add(panel1, BorderLayout.NORTH);
      contentPane.add(scrollPane, BorderLayout.CENTER);
      // adding online users to pane
      contentPane.add(online, BorderLayout.EAST);

      setContentPane(contentPane);
   }

   /**
    * appends a new message to the textAreaOutput.
    */

   public void UpdateMessages(String message)
   {

      textAreaOutput.append("\n" + "" + message);
   }

   /**
    * appends a new user to the onlineusersArea.
    */
   public void updateOnlineUsers(String user)
   {
      onlineusersArea.append("\n" + "" + user);
   }

   // ActionListener
   /**
    * this is the action listener from here we call the constructor and then the
    * constructor does the action for the specific command.
    */

   public void actionPerformed(ActionEvent e)
   {

      controller.actionPerformed(e);
   }

}
 