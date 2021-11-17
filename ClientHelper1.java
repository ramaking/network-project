import java.net.*;
import java.io.*;

public class ClientHelper1 {
    private MyClientDatagramSocket mySocket;
    private InetAddress serverHost;
    private int serverPort;
 
    ClientHelper1(String hostName, String portNum) 
       throws SocketException, UnknownHostException { 
        this.serverHost = InetAddress.getByName(hostName);   
        this.serverPort = Integer.parseInt(portNum);
       // instantiates a datagram socket for both sending
       // and receiving data
        this.mySocket = new MyClientDatagramSocket(); 
    } 
     
    public void resistConnent(String email) 
       throws SocketException, IOException { 
       mySocket.sendMessage( serverHost, serverPort, email);
        // now receive the echo
    } //end getEcho
 
    public void done( ) throws SocketException {
       mySocket.close( );
    }  //end done
}
