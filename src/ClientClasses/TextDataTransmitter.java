package ClientClasses;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * Transmits text data from the given reader to given writer and runs as a
 * separete thread.
 */
class TextDataTransmitter extends Thread
{
   private BufferedReader mReader;
   private PrintWriter mWriter;

   public TextDataTransmitter(BufferedReader aReader, PrintWriter aWriter)
   {
      mReader = aReader;
      mWriter = aWriter;
   }
   /**
    * Until interrupted reads a text line from the reader and sends it to the
    * writer.
    */
   public void run()
   {
      try
      {
         while (!isInterrupted())
         {
            String data = mReader.readLine();
            mWriter.println(data);
            mWriter.flush();
         }
      }
      catch (IOException ioe)
      {
         System.err.println("Lost connection to server.");
         System.exit(-1);
      }
   }
}