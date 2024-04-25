import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.time.LocalTime;

public class Clock_One {

	public static void main(String[] args) {
		try {
			// Server 1
			ServerIntf s1 = new ServerImpl(LocalTime.parse("02:50:00", AppConstants.formatter));
			Registry registry1 = LocateRegistry.createRegistry(AppConstants.SERVER_PORT_1);
			registry1.rebind(ServerImpl.class.getSimpleName(), s1);
			System.out.println(String.format("Server 1 started on port " + AppConstants.SERVER_PORT_1));
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

}
