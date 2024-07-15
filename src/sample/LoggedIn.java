package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.*;

public class LoggedIn {

    @FXML
    private Button logout_btn;

    @FXML
    private Button notificationBtn;

    // File path for storing notices
    private static final String NOTICE_FILE_PATH = "notice.txt";

    // Field to keep track of the new notice count
    private int newNoticeCount = 0;

    public void logout_page(ActionEvent event) throws IOException {
        Main mx = new Main();
        mx.changeScene("sample.fxml");
    }

    @FXML
    void blood_btn(ActionEvent event) throws IOException {
        Main bld = new Main();
        bld.changeScene("BloodOrg.fxml");
    }

    @FXML
    void clothes_btn(ActionEvent event) throws IOException {
        Main clo = new Main();
        clo.changeScene("ClothesOrg.fxml");
    }

    @FXML
    void food_btn(ActionEvent event) throws IOException {
        Main foo = new Main();
        foo.changeScene("FoodOrg.fxml");
    }

    @FXML
    void money_btn(ActionEvent event) throws IOException {
        Main mon = new Main();
        mon.changeScene("MoneyOrg.fxml");
    }

    @FXML
    void study_btn(ActionEvent event) throws IOException {
        Main stu = new Main();
        stu.changeScene("StudyOrg.fxml");
    }

    public void msg_admin(ActionEvent event) throws IOException {
        Main adms = new Main();
        adms.changeScene("Chatbox_1.fxml");
    }

    // Method to display notifications
    @FXML
    private void showNotifications(ActionEvent event) {
        // Load notices from file
        String notices = loadNoticesFromFile();
        if (notices.isEmpty()) {
            // If no notices, show a message
            showAlert("Notifications", "No new notifications available.");
        } else {
            // If there are notices, show them and reset the count
            showAlert("Notifications", notices);
            newNoticeCount = 0;
            updateNotificationButton();
        }
    }

    // Method to load notices from file
    private String loadNoticesFromFile() {
        StringBuilder notices = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(NOTICE_FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                notices.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return notices.toString();
    }

    // Method to save notice to file
    private void saveNoticeToFile(String notice) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(NOTICE_FILE_PATH, true))) {
            writer.write(notice + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to update notification button text
    private void updateNotificationButton() {
        // Update the notification button text
        notificationBtn.setText("Notifications (" + newNoticeCount + ")");
    }

    // Method to show alert dialog
    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    // Method to handle the request button action
    @FXML
    private void requestSomething(ActionEvent event) {
        try {
            // Load the request form FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("requestForm.fxml"));
            Parent root = loader.load();

            // Create a new stage for the request form
            Stage stage = new Stage();
            stage.setTitle("Request Form");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void openEventPage(ActionEvent event) {
        try {
            // Load the event page FXML file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("event.fxml"));
            Parent root = loader.load();

            // Create a new stage for the event page
            Stage stage = new Stage();
            stage.setTitle("Events");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

