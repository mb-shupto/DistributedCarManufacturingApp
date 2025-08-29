package supto;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.io.IOException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ManageDefectsController {

    @FXML
    public ComboBox<String> defectComboBox;
    @FXML
    public ComboBox<String> teamComboBox;
    @FXML
    public ComboBox<String> statusComboBox;
    @FXML
    public Label outputLabel;
    private DefectReportService service;

    @FXML
    private void initialize() {
        defectComboBox.getItems().addAll("Defect 1: Faulty Brake", "Defect 2: Paint Scratch", "Defect 3: Engine Noise");
        defectComboBox.setValue("Defect 1: Faulty Brake");

        teamComboBox.getItems().addAll("Team A", "Team B", "Team C");
        teamComboBox.setValue("Team A");

        statusComboBox.getItems().addAll("In Progress", "Fixed");
        statusComboBox.setValue("In Progress");

        outputLabel.setText(""); // Clear the label initially

        // Connect to RMI server
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            service = (DefectReportService) registry.lookup("DefectReportService");
            outputLabel.setText("Connected to server successfully.");
        } catch (Exception e) {
            outputLabel.setText("Error connecting to server: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @FXML
    private void updateReport() {
        String defect = defectComboBox.getValue();
        String team = teamComboBox.getValue();
        String status = statusComboBox.getValue();

        if (defect == null || team == null || status == null) {
            outputLabel.setText("Error: Please select a defect, team, and status.");
            return;
        }

        String report = defect + " assigned to " + team + " and marked as " + status + ".";

        try {
            service.saveDefectReport(report);
            outputLabel.setText("Report updated successfully: " + report);
        } catch (Exception e) {
            outputLabel.setText("Error saving report: " + e.getMessage());
        }
    }

    @FXML
    private void viewDefectReports(ActionEvent actionEvent) throws IOException {try{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/supto/defectOutput.fxml"));
        Parent root = fxmlLoader.load();
        Node source = (Node) actionEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle("Defect Output Dashboard");
        stage.show();
    }catch (IOException e){
        e.printStackTrace();
    }
  }

    @FXML
    public void goBack(ActionEvent actionEvent) {
    }
}
