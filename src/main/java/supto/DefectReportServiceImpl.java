package supto;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class DefectReportServiceImpl extends UnicastRemoteObject implements DefectReportService {
    private StringBuilder reports = new StringBuilder();

    protected DefectReportServiceImpl() throws RemoteException {
        super();
    }

    @Override
    public void saveDefectReport(String report) throws RemoteException {
        reports.append(report).append("\n");
    }

    @Override
    public String getAllDefectReports() throws RemoteException {
        return reports.toString();
    }

    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.createRegistry(1099);
            DefectReportService service = new DefectReportServiceImpl();
            registry.bind("DefectReportService", service);
            System.out.println("Server ready. Waiting for client calls...");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
