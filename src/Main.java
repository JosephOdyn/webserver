import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;




public class Main {

    public static void main(String[] args) {


        try {
            System.out.println("About to create the Server Scoket....");
            ServerSocket server = new ServerSocket(50001);         //to create a sever socket
            System.out.println("Server socket created !!!!");

            System.out.println("About to accept....");
            Socket client = server.accept();    //waiting for a client it's a blocking system call
            System.out.println("Accept is returned !!!!");

            Date today = new Date();
            PrintWriter out = new PrintWriter (client.getOutputStream());
            out.println("Hello I'm Server. My time is " + today);   //write to the client

            out.flush();   // something inbetween will be flushed
            System.out.println("Sent data time " + today);

            client.close();     //alwasys don't forget to close the socket
            System.out.println("Closed the connection....");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
