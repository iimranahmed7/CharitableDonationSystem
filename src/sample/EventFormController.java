package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class EventFormController {

    @FXML
    private TextField eventNameField;

    @FXML
    private TextField eventPlaceField;

    @FXML
    private TextField eventTimeField;

    @FXML
    private TextArea eventDescriptionArea;

    @FXML
    private void postEvent() {
        String eventName = eventNameField.getText().trim();
        String eventPlace = eventPlaceField.getText().trim();
        String eventTime = eventTimeField.getText().trim();
        String eventDescription = eventDescriptionArea.getText().trim();

        // Perform validation
        if (eventName.isEmpty() || eventPlace.isEmpty() || eventTime.isEmpty() || eventDescription.isEmpty()) {
            showAlert("Error", "Please fill in all fields.");
            return;
        }

        // Save the event details to a .txt file
        saveEventToFile(eventName, eventPlace, eventTime, eventDescription);

        // Show success message
        showAlert("Success", "Event posted successfully.");

        // Clear the form fields
        clearFormFields();
    }

    private void saveEventToFile(String eventName, String eventPlace, String eventTime, String eventDescription) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("events.txt", true))) {
            // Append the event details to the file
            writer.write("Event Name: " + eventName + "\n");
            writer.write("Event Place: " + eventPlace + "\n");
            writer.write("Event Time: " + eventTime + "\n");
            writer.write("Event Description: " + eventDescription + "\n\n");
        } catch (IOException e) {
            e.printStackTrace();
            showAlert("Error", "Failed to save event details.");
        }
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    private void clearFormFields() {
        eventNameField.clear();
        eventPlaceField.clear();
        eventTimeField.clear();
        eventDescriptionArea.clear();
    }

    public void setEventsContent(String eventsContent) {
    }
}
