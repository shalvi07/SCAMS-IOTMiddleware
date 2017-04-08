import java.util.*;
public class SensorData {
	private int noOfSensors;
	private ArrayList<Integer> typesOfSensors;
	private ArrayList<Double> data;
	
	public SensorData() {
		this.noOfSensors = 0;
		this.typesOfSensors = new ArrayList<Integer>();
		this.data = new ArrayList<Double>();
	}
	
	public SensorData(int sensors, ArrayList<Integer> types, ArrayList<Double> newData) {
		this.noOfSensors = sensors;
		this.typesOfSensors = types;
		this.data = newData;
	}

	public int getNoOfSensors(){
		
		return this.noOfSensors;
	}
	
	public ArrayList<Integer> getTypesOfSensors(){
		return this.typesOfSensors;
	}

	public ArrayList<Double> getData(){
		return this.data;
	}

	public void setNoOfSensors(int sensors){
		this.noOfSensors = sensors;
	}
	
	public void setTypesOfSensors(ArrayList<Integer> types){
		this.typesOfSensors = types;
	}

	public void setData(ArrayList<Double> newData){
		this.data = newData;
	}
}
