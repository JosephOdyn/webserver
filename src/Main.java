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
            ServerSocket server = new ServerSocket(60001);         //to create a sever socket
            System.out.println("This server is ON !!!!");

            System.out.println("Waiting for connections....");
            Socket client = server.accept();    //waiting for a client it's a blocking system call
            System.out.println("Connection made !!!!");

            Date today = new Date();
            PrintWriter out = new PrintWriter (client.getOutputStream());
            out.println("Hello client, I'm Module 3 temp-Server. Today " + today + " I discovered that I like apples ¯\_(ツ)_/¯  );   //write to the client

            out.flush();   // something inbetween will be flushed
            System.out.println("Ok, bye");

            client.close();     //alwasys don't forget to close the socket
            System.out.println("Closed the connection....");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
