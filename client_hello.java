import java.io.*;
import java.net.*;

public class client_hello {
    public static void main(String[] args) {
        try {

            String string="ababba";
            Socket s = new Socket("localhost", 1234);

            DataOutputStream dout=new DataOutputStream(s.getOutputStream());  
            dout.writeUTF(string);

            DataInputStream din = new DataInputStream(s.getInputStream());
            String  str=(String)din.readUTF();
            System.out.println(""+str);   

            dout.flush();
            dout.close();
            s.close();
        } 
        catch (Exception e) {
            System.out.println(e);
        }
    }
}