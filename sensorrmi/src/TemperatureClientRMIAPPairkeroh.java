import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.HashMap;
import ftmk.rmi.sensor.TemperatureSensor;

/**
 * This class represent the client-side of RMI application
 * 
 * @author emalianakasmuri
 *
 */
public class TemperatureClientRMIAPPairkeroh {

	public static void main(String[] args) {
		
		
		try {
			
			// Get registry
			Registry rmiRegistry = LocateRegistry.getRegistry("localhost",1000);
			
			// Look-up for the remote object
			TemperatureSensor remoteSensorAyerKeroh = (TemperatureSensor) rmiRegistry.lookup("SensorAirKeroh"); 
			
			HashMap<String, Integer> temperaturesForSpecificDays = remoteSensorAyerKeroh.getTemperatureForSpecificDay();
			
			float averageTemperature = remoteSensorAyerKeroh.getAverageTemparatureOfTheWeek();
			
			System.out.println("Temperatures for this week in Ayer Keroh (in Celcius): ");
			System.out.println(temperaturesForSpecificDays);
			System.out.println("The average temperature in Ayer Keroh is "+ String.format("%3.2f", averageTemperature)+" celcius");
			
		} catch (RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
