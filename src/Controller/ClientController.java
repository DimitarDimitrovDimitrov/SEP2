package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Observable;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import ChatSystem.Model;
import Controller.Controller;
import Model.Message;
import View.View;

public class ClientController implements Controller
{
   private Model model;
   private View view;
   private JTextField userNameField;
   private JTextField textFieldInput;
   private JTextArea textAreaOutput;

   ObjectOutputStream outToServer;
   ObjectInputStream inFromServer;
   Socket clientSocket;

   public ClientController(Model model, View view)
   {
      this.model = model;
      this.view = view;
      ((Observable) this.model).addObserver(view);

      textFieldInput.addActionListener(new ActionListener()
      {
         public void actionPerformed(ActionEvent event)
         {
            sendMessageEnter(event.getActionCommand());

         }
      });

   }

   public void sendMessageEnter(String message)
   {

      try
      {

         // create client socket, connect to server.
         String timeStamp = new SimpleDateFormat("HH.mm.ss")
               .format(new java.util.Date());
         textFieldInput.getText();

         message = "[" + timeStamp + "] " + userNameField.getText() + ": "+ textFieldInput.getText();
         Message m = new Message(message);

         outToServer.writeObject(m);

         textFieldInput.setText("");

      }
      catch (Exception ex)
      {

      }
   }

   public void execute(String message)
   {
      if (message.equals("Send"))
      {

         String input = view.getAndRemoveInput();
         if (input.length() > 0)
         {
            model.addMessage(new Message(input));
         }
         else if (message.equals("Quit"))
         {
            System.exit(0);
         }
      }
   }
   

   public void actionPerformed(ActionEvent e)
   {
      
      
      
       if(e.getActionCommand().equals("Quit"))
      {
         System.exit(0);
         System.out.println("code");
      }
      
   }
   
   

}