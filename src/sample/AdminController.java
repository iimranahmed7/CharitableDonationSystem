package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;

import java.io.*;

public class AdminController {

    @FXML
    private TextArea money_ta;

    @FXML
    private TextArea food_ta;

    @FXML
    private TextArea clothes_ta;

    @FXML
    private TextArea blood_ta;

    @FXML
    private TextArea study_ta;

    @FXML
    private void initialize() {
        // Initialize text areas with default prompt text
        money_ta.setPromptText("The data for donated money will be shown here!");
        food_ta.setPromptText("The data for donated food will be shown here!");
        clothes_ta.setPromptText("The data for donated clothes will be shown here!");
        blood_ta.setPromptText("The data for donated blood will be shown here!");
        study_ta.setPromptText("The data for donated Study Materials will be shown here!");
    }

    @FXML
    private void show_one(ActionEvent event) {
        displayDataFromFile("money.txt", money_ta);
    }

    @FXML
    private void show_two(ActionEvent event) {
        displayDataFromFile("food.txt", food_ta);
    }

    @FXML
    private void show_three(ActionEvent event) {
        displayDataFromFile("clothes.txt", clothes_ta);
    }

    @FXML
    private void show_four(ActionEvent event) {
        displayDataFromFile("blood.txt", blood_ta);
    }

    @FXML
    private void show_fifth(ActionEvent event) {
        displayDataFromFile("study.txt", study_ta);
    }

    @FXML
    public void logout_btn(ActionEvent event) throws IOException {
        changeScene("confirmation_page.fxml");
    }

    @FXML
    public void msg_client(ActionEvent event) throws IOException {
        changeScene("Chatbox_1.fxml");
    }

    @FXML
    private void openEventForm(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("EventForm.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Post Event");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            showAlert("Error", "Failed to open event form.");
        }
    }

    @FXML
    private void openNoticeForm(ActionEvent event) {
        try {
            // Load the FXML file for the notice form
            FXMLLoader loader = new FXMLLoader(getClass().getResource("NoticeForm.fxml"));
            Parent root = loader.load();

            // Create a new stage and set the scene
            Stage stage = new Stage();
            stage.setTitle("Post Notice");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            showAlert("Error", "Failed to open notice form.");
        }
    }

    @FXML
    public void viewRequests(ActionEvent event) {
        try {
            File requestsFile = new File("requests.txt");
            if (!requestsFile.exists()) {
                showAlert("Error", "No requests found.");
                return;
            }

            StringBuilder requests = new StringBuilder();
            BufferedReader reader = new BufferedReader(new FileReader(requestsFile));
            String line;
            while ((line = reader.readLine()) != null) {
                requests.append(line).append("\n");
            }
            reader.close();

            showAlert("User Requests", requests.toString());
        } catch (IOException e) {
            e.printStackTrace();
            showAlert("Error", "Failed to load requests.");
        }
    }

    private void displayDataFromFile(String fileName, TextArea textArea) {
        try {
            File file = new File(fileName);
            if (file.exists()) {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String line;
                while ((line = reader.readLine()) != null) {
                    textArea.appendText(line + "\n");
                }
                reader.close();
            } else {
                textArea.setText("File not found.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void changeScene(String fxmlFile) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(fxmlFile));
            Scene scene = new Scene(root);
            Stage stage = (Stage) money_ta.getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            showAlert("Error", "Failed to load scene.");
        }
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
