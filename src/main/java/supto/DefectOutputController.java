package supto;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import java.io.IOException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class DefectOutputController {
    @FXML private TextArea outputTextArea;

    private DefectReportService service;

    @FXML
    private void initialize() {
        // Connect to RMI server
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            service = (DefectReportService) registry.lookup("DefectReportService");
            String reports = service.getAllDefectReports();
            outputTextArea.setText(reports.isEmpty() ? "No reports found." : reports);
        } catch (Exception e) {
            outputTextArea.setText("Error loading reports: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @FXML
    private void goBack(ActionEvent actionEvent) throws IOException {
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/supto/manageDefects.fxml"));
            Parent root = fxmlLoader.load();
            Node source = (Node) actionEvent.getSource();
            Stage stage = (Stage) source.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Manage Defects Dashboard");
            stage.show();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
