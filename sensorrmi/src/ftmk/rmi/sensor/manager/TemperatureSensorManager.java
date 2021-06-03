package ftmk.rmi.sensor.manager;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

import ftmk.rmi.sensor.TemperatureSensor;

/**
 * This class manage the value of temperature from the sensor.
 * 
 * @author emalianakasmuri
 *
 */
public class TemperatureSensorManager extends UnicastRemoteObject implements TemperatureSensor {
	
	// temperatures for 7 days.
	private HashMap<String, Integer> temperatures = new HashMap<>();

	public TemperatureSensorManager() throws RemoteException {
		super();
		// set the temperature whenever the object created.
		setTemperatures();
		
	}

	@Override
	public int getTemperature() throws RemoteException {
		
		return 35;
	}
	
	// return all the temperatures for 7 days
	public HashMap<String, Integer> getTemperatureForSpecificDay() throws RemoteException{
		return temperatures;
		
	}
	
	// set the temperatures
	public void setTemperatures() {
		temperatures.put("Monday", 32);
		temperatures.put("Tuesday", 31);
		temperatures.put("Wenesday", 33);
		temperatures.put("Thursday", 35);
		temperatures.put("Friday", 36);
		temperatures.put("Saturday", 33);
		temperatures.put("Sunday", 33);
	}
	
	// calculate and return the average temperature 
	public float getAverageTemparatureOfTheWeek() throws RemoteException{
		
		float totalTemperature = 0;
		for(int temperature: temperatures.values()) {
			totalTemperature += temperature;
		}
		return totalTemperature/temperatures.size();
		
	}

}