import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalTime;

public class ServerImpl extends UnicastRemoteObject implements ServerIntf {

	private static final long serialVersionUID = -6810169856453308607L;

	private LocalTime currtime;

	public ServerImpl(LocalTime currtime) throws RemoteException {
		this.currtime = currtime;
	}

	@Override
	public LocalTime getTime() throws RemoteException {
		return currtime;
	}

	@Override
	public void adjustTime(LocalTime clientTime, long timeDiff) throws RemoteException {
		long localTime = clientTime.toNanoOfDay();
		long serventTime = this.getTime().toNanoOfDay();
		long newNanos = serventTime - localTime;
		newNanos = newNanos * -1 + timeDiff + serventTime;
		LocalTime newLocalTime = LocalTime.ofNanoOfDay(newNanos);
		System.out.println("Updated time " + AppConstants.formatter.format(newLocalTime));
		this.currtime = newLocalTime;
	}

}
