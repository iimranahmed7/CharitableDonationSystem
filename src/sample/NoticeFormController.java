package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert;
import java.io.*;

public class NoticeFormController {

    @FXML
    private TextArea previousNoticesTextArea;

    @FXML
    private TextArea noticeTextArea;

    // File path for storing notices
    private static final String NOTICE_FILE_PATH = "notice.txt";

    @FXML
    void initialize() {
        // Load previous notices when the form is initialized
        loadPreviousNotices();
    }

    @FXML
    void submitNotice(ActionEvent event) {
        String notice = noticeTextArea.getText();
        if (!notice.isEmpty()) {
            // Save the notice to the file
            saveNoticeToFile(notice);
            // Clear the notice text area
            noticeTextArea.clear();
            // Load and display the updated list of previous notices
            loadPreviousNotices();
            // Show confirmation message
            showAlert(Alert.AlertType.INFORMATION, "Notice Submitted", "Your notice has been submitted successfully.");
        } else {
            showAlert(Alert.AlertType.ERROR, "Error", "Please enter a notice before submitting.");
        }
    }

    @FXML
    void deletePreviousNotices(ActionEvent event) {
        // Delete previous notices from the file
        deleteNoticeFile();
        // Clear the text area displaying previous notices
        previousNoticesTextArea.clear();
        // Show confirmation message
        showAlert(Alert.AlertType.INFORMATION, "Notices Deleted", "All previous notices have been deleted.");
    }

    // Method to load previous notices from file and display them
    private void loadPreviousNotices() {
        StringBuilder notices = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(NOTICE_FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                notices.append(line).append("\n");
            }
            previousNoticesTextArea.setText(notices.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to save notice to file
    private void saveNoticeToFile(String notice) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(NOTICE_FILE_PATH, true))) {
            writer.write(notice + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to delete notice file
    private void deleteNoticeFile() {
        File file = new File(NOTICE_FILE_PATH);
        if (file.exists()) {
            file.delete();
        }
    }

    // Method to show alert dialog
    private void showAlert(Alert.AlertType alertType, String title, String content) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
