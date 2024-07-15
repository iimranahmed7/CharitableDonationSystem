package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RequestFormController {

    @FXML
    private TextField emailField;

    @FXML
    private TextField nameField;

    @FXML
    private TextField mobileField;

    @FXML
    private TextField requestField;

    private static final String REQUEST_FILE_NAME = "requests.txt";

    @FXML
    void submitRequest(ActionEvent event) {
        String email = emailField.getText().trim();
        String name = nameField.getText().trim();
        String mobile = mobileField.getText().trim();
        String request = requestField.getText().trim();

        // Perform validation
        if (email.isEmpty() || name.isEmpty() || mobile.isEmpty() || request.isEmpty()) {
            showAlert("Error", "Please fill in all fields.");
            return;
        }

        // Save the request to a text file
        saveRequestToFile(name, email, mobile, request);

        // Show success message
        showAlert("Success", "Request submitted successfully.");

        // Clear the form fields
        clearFormFields();
    }

    // Method to save request to a text file
    private void saveRequestToFile(String name, String email, String mobile, String request) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(REQUEST_FILE_NAME, true))) {
            // Check if file exists, if not create it
            File file = new File(REQUEST_FILE_NAME);
            if (!file.exists()) {
                file.createNewFile();
            }

            // Get current date and time
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

            // Generate unique ID
            int requestId = generateRequestId();

            // Format request data
            String requestData = String.format("[%s] ID: %d | Name: %s | Email: %s | Mobile: %s | Request: %s%n",
                    now.format(formatter), requestId, name, email, mobile, request);

            // Write request data to file
            writer.write(requestData);
        } catch (IOException e) {
            e.printStackTrace();
            showAlert("Error", "Failed to save request. Please try again.");
        }
    }

    // Method to generate a unique request ID
    private int generateRequestId() {
        // You can implement your own logic to generate unique IDs here
        // For simplicity, a random number is generated in this example
        return (int) (Math.random() * 1000);
    }

    // Method to show alert dialog
    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    // Method to clear form fields
    private void clearFormFields() {
        emailField.clear();
        nameField.clear();
        mobileField.clear();
        requestField.clear();
    }
}
