
import java.net.*;
import java.io.*;

public class NodeSimulator {
	public static void main(String args[])throws Exception{
		
		InetAddress host = InetAddress.getLocalHost();
		Socket nodeSocket = null;
		OutputStream oos = null;
		
		for (int i=0;i<5;i++){
			System.out.println("Node is Sending Data");
			nodeSocket = new Socket(host.getHostName(),9876);
			oos = (OutputStream) nodeSocket.getOutputStream();
			String query = "you have tha data";
			String end = "quit";
			if(i==4){
				oos.write(end.getBytes("iso8859_1"));
			}
			else{
				oos.write(query.getBytes("iso8859_1"));
			}
			oos.close();
		}
		
		
	}
}
