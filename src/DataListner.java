import java.io.*;
import java.net.*;
import java.util.*;


public class DataListner {
	
	public static void main(String args[])throws Exception{
		
		try{
			ServerSocket ss = new ServerSocket(9876);
			while(true)
			{
				Socket nodeSocket = ss.accept();
				NodeServiceThread nodeThread = new NodeServiceThread(nodeSocket);
				nodeThread.start();
			}			
		}catch(Exception e){System.out.println(e);}
	}
}

class NodeServiceThread extends Thread{
	Socket nodeSocket;
	boolean running = true;
	Queue<String> sensorDataQueue = new LinkedList<>();
	String nodeData = null;
	
	NodeServiceThread(Socket s){
		nodeSocket = s;
	}
	
	public void run(){
		
		System.out.println("Listening for Node Data");
		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(nodeSocket.getInputStream()));
			while(running){
				while(br.readLine() != null){
				String nodeData = br.readLine();
				sensorDataQueue.add(nodeData);
				/* Create a object of queue data and forward the data to diaggregration stage*/
				SensorNode sen1 = new SensorNode();
				String sensorData = sensorDataQueue.remove();
				String listData[] = sensorData.split("\\s*,\\s");
				sen1.setNodeId(listData[0]);
				sen1.setMediumValue(Integer.parseInt(listData[1]));
				sen1.setLocation(listData[2]);
				
				
				}
				if(nodeData.equalsIgnoreCase(null)){
					running  = false;
					System.out.println("Sensor need to be repaired");
				}
			}
		}catch(Exception e){e.printStackTrace();
		}
	}
}