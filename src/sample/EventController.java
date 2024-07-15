package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class EventController {

    @FXML
    private TextArea eventsTextArea;

    // Method to initialize the controller after the FXML has been loaded
    @FXML
    private void initialize() {
        // Load events content when the controller is initialized
        String eventsContent = readEventsFromFile();
        eventsTextArea.setText(eventsContent);
    }

    // Method to read events from the events.txt file
    private String readEventsFromFile() {
        StringBuilder eventsContent = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader("events.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                eventsContent.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return eventsContent.toString();
    }
}
