package ClientClasses;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

public class GUI extends JFrame implements WindowListener,MouseListener,KeyListener
{
  private TextArea MessageArea=null;
  private TextField SendArea=null;
  private String Username=null;
  private Button send;
  private ChatClient c;
  GUI(String s)
  {
     super(s);
     this.addWindowListener(this);
     this.setSize(800,600);
     this.setResizable(true);
     this.setLayout(new BorderLayout());
     this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     
    MessageArea=new TextArea();
    MessageArea.setEditable(false);
    this.add(MessageArea,"Center");
    MessageArea.setFont(new Font("Arial",Font.PLAIN,16));
    
    Panel p=new Panel();
    p.setLayout(new FlowLayout());
    
    SendArea=new TextField(30);
    SendArea.addKeyListener(this);
    SendArea.setFont(new Font("Arial",Font.PLAIN,16));
    
    p.add(SendArea);
    p.setBackground(new Color(221,221,221));
     Button send =new Button("send");
     send.addMouseListener(this);
     p.add(send);
     Button clear=new Button("clear");
     clear.addMouseListener(this);
     p.add(clear);
     this.add(p,"South");
     this.setVisible(true);
     SendArea.requestFocus();
  }
  
  public static void main(String [] args)
  {
     GUI c=new GUI("gui");
  }
  
  private class MyButtonListener implements ActionListener
  {
     public void actionPerformed(ActionEvent e)
     {

        if (e.getSource() == send)
        {
            
        }
     }
  }
   @Override
   public void keyTyped(KeyEvent e)
   {
      // TODO Auto-generated method stub
      
   }

   @Override
   public void keyPressed(KeyEvent e)
   {
      // TODO Auto-generated method stub
      
   }

   @Override
   public void keyReleased(KeyEvent e)
   {
      // TODO Auto-generated method stub
      
   }

   @Override
   public void mouseClicked(MouseEvent e)
   {
      // TODO Auto-generated method stub
      
   }

   @Override
   public void mousePressed(MouseEvent e)
   {
      // TODO Auto-generated method stub
      
   }

   @Override
   public void mouseReleased(MouseEvent e)
   {
      // TODO Auto-generated method stub
      
   }

   @Override
   public void mouseEntered(MouseEvent e)
   {
      // TODO Auto-generated method stub
      
   }

   @Override
   public void mouseExited(MouseEvent e)
   {
      // TODO Auto-generated method stub
      
   }

   @Override
   public void windowOpened(WindowEvent e)
   {
      // TODO Auto-generated method stub
      
   }

   @Override
   public void windowClosing(WindowEvent e)
   {
      // TODO Auto-generated method stub
      
   }

   @Override
   public void windowClosed(WindowEvent e)
   {
      // TODO Auto-generated method stub
      
   }

   @Override
   public void windowIconified(WindowEvent e)
   {
      // TODO Auto-generated method stub
      
   }

   @Override
   public void windowDeiconified(WindowEvent e)
   {
      // TODO Auto-generated method stub
      
   }

   @Override
   public void windowActivated(WindowEvent e)
   {
      // TODO Auto-generated method stub
      
   }

   @Override
   public void windowDeactivated(WindowEvent e)
   {
      // TODO Auto-generated method stub
      
   }

}
  
