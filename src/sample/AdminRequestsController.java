package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminRequestsController implements Initializable {

    @FXML
    private VBox requestContainer;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Load requests from the file or database
        // For demonstration purposes, let's assume we have a list of requests
        // You can replace this with your actual logic to fetch requests
        // List<Request> requests = fetchRequestsFromDatabase();

        // For demonstration, let's assume we have the following requests:
        String[] requests = {
                "Request 1",
                "Request 2",
                "Request 3"
        };

        // Create a RequestSection for each request and add it to the container
        for (int i = 0; i < requests.length; i++) {
            RequestSection requestSection = new RequestSection(i + 1, requests[i]);
            requestContainer.getChildren().add(requestSection);
        }
    }
}
