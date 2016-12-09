package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.text.SimpleDateFormat;

import java.util.ArrayList;

import ChatSystem.ClientReciever;
import Controller.Controller;
import Model.Message;
import Model.Messages;
import Model.Model;
import Model.OnlineList;
import View.ChatView;
import View.View;

public class ClientController implements Controller
{
   private Model model;
   private View view;
   ObjectOutputStream outToServer;
   ObjectInputStream inFromServer;
   Socket clientSocket;
   private Messages list;
   private OnlineList onlineList;

   public ClientController(Model model, View view)
   {
      this.model = model;
      this.view = view;
      onlineList = new OnlineList();
      try
      {

         final int PORT = 6789;
         final String HOST = "10.52.230.109";
         System.out.println("stuff");
         clientSocket = new Socket(HOST, PORT);
         // create input stream attached to the socket.
         System.out.println("inputstream");
         inFromServer = new ObjectInputStream(clientSocket.getInputStream());
         System.out.println("stuff1.5");
         // create output stream attached to the socket.
         outToServer = new ObjectOutputStream(clientSocket.getOutputStream());
         System.out.println("stuff2");
         view.UpdateMessages("\n" + "Client> connected to server");
         ClientReciever r = new ClientReciever(inFromServer, this);
         new Thread(r, "Reciever").start();

      }
      catch (IOException ex)
      {
         System.out.println("ERROR");
         ex.printStackTrace();

      }

   }

   public void updateOnlineUsers(String users)
   {
      view.updateOnlineUsers(users);
   }

   public void UpdateMessages(String body)
   {
      view.UpdateMessages(body);

   }
   
   
   public void sendMessageEnter(String message)
   {

      try
      {

         // create client socket, connect to server.
         String timeStamp = new SimpleDateFormat("HH.mm.ss").format(new java.util.Date());

         message = "[" + timeStamp + "] " + view.getUserNameField() + ": "+ view.getTextFieldInput();
         Message m = new Message(message, true);

         outToServer.writeObject(m);

         view.setTextFieldInput();

      }
      catch (Exception ex)
      {

      }
   }

   public void actionPerformed(ActionEvent e)
   {
      if (e.getActionCommand().equals("Set"))
      {

         try
         {
            System.out.println("send to server " + view.getUserNameField());
            outToServer.writeObject(new Message(view.getUserNameField(), false));
         }
         catch (IOException e1)
         {
            // TODO Auto-generated catch block
            e1.printStackTrace();
         }

        

      }
      if (e.getActionCommand().equals("Quit"))
      {
         System.exit(0);
         System.out.println("code");
      }

   }

  
   @Override
   public void execute(String message)
   {
      // TODO Auto-generated method stub

   }

  

}