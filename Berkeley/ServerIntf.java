import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalTime;

public interface ServerIntf extends Remote {

	LocalTime getTime() throws RemoteException;

	void adjustTime(LocalTime clientTime, long timeDiff) throws RemoteException;
}
