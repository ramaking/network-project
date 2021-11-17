import java.io.*;
import java.util.Vector;

public class Resister {
    public static Vector<String> emailVector = new Vector<String> (5,3);
    public static void main(String[] args) {
        int serverPort = 1117;
        try {
            MyServerDatagramSocket mySocket = new MyServerDatagramSocket(serverPort);
            System.out.println("server ready");
            while (true) {
                // UDP - client - resister
                String request = mySocket.receiveMessage();
                emailVector.add(request);
                System.out.println("message received : " + request);
                System.out.println("Request received");
                //String message = request.getMessage();
                //System.out.println("message received : " + message);
                System.out.println(emailVector.elements());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}