import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.time.LocalTime;

public class Clock_Two {

	public static void main(String[] args) {
		try {
			// Server 2
			ServerIntf s2 = new ServerImpl(LocalTime.parse("03:24:00", AppConstants.formatter));
			Registry registry2 = LocateRegistry.createRegistry(AppConstants.SERVER_PORT_2);
			registry2.rebind(ServerImpl.class.getSimpleName(), s2);
			System.out.println(String.format("Server 2 started on port "+AppConstants.SERVER_PORT_2));
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

}
