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
onlineList=new OnlineList();
      try
      {

         final int PORT = 6789;
         final String HOST = "localhost";
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

   public void sendMessageEnter(String message)
   {

      try
      {

         // create client socket, connect to server.
         String timeStamp = new SimpleDateFormat("HH.mm.ss")
               .format(new java.util.Date());

         message = "[" + timeStamp + "] " + view.getUserNameField() + ": "
               + view.getTextFieldInput();
         Message m = new Message(message);

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
         
          String onlinestring=new String();
if(view.getUserNameField()!= null)
{
         onlineList.add(view.getUserNameField());
}

         for (int i = 0; i < onlineList.size(); i++)
         {
            onlinestring +="\n" + onlineList.getUsers(i);
         }
   System.out.println(onlinestring);
         view.setText(onlinestring);

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

   public void UpdateMessages(String body)
   {
      view.UpdateMessages(body);

   }

}