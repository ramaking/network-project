import java.io.*;

/*
1. 클라이언트 활성화와 동시에 서버 접속(UDP)
2. 서버에 유저 데이터 전송
3. 이메일(key)를 통해 데이터를 전송(TCP)

*/

public class Client {
    static final String endMessage = ".";
    public static void main(String[] args) {
        //스레드 생성 서버 연결(UDP)

        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);
        try{
            System.out.println("what is the name of server host?");
            String hostName = br.readLine();
            if (hostName.length() == 0) // if user did not enter a name
            hostName = "localhost";
            System.out.println("what is the port number of server host?");
            String portNum = br.readLine();
            if(portNum.length() == 0)
                portNum = "1117";
            ClientHelper1 helper1 = 
                new ClientHelper1(hostName, portNum);
            boolean done = false;
            String message;
            while(!done){
                System.out.println("send message");
                message = br.readLine();
                if((message.trim()).equals(endMessage)){
                    done = true;
                    helper1.done();
                } else{
                    helper1.resistConnent(message);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
