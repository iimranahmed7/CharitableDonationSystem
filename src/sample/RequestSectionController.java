package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class RequestSectionController {

    @FXML
    private Label requestLabel;

    @FXML
    private Button deleteButton;

    private int requestId;
    private String request;

    public void setRequestData(int requestId, String request) {
        this.requestId = requestId;
        this.request = request;
        requestLabel.setText(request);
        // Hide the delete button for non-admin users
        if (!isAdmin()) {
            deleteButton.setVisible(false);
        }
    }

    @FXML
    void deleteRequest(ActionEvent event) {
        // Implement logic to delete the request based on the request ID
        // For example, you can remove it from the file or mark it as fulfilled
        // Then, show a confirmation dialog
        showAlert("Request Deletion", "Are you sure you want to delete this request?");
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    private boolean isAdmin() {
        // Implement logic to check if the user is an admin
        // For example, you can use authentication or store user roles in a database
        return true; // Return true for demonstration purposes
    }
}
