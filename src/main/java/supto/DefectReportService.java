package supto;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface DefectReportService extends Remote {
    void saveDefectReport(String report) throws RemoteException;
    String getAllDefectReports() throws RemoteException;
}
