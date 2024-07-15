package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.HBox;
import java.io.IOException;

public class RequestSection extends HBox {
    private final int requestId;
    private final String request;

    public RequestSection(int requestId, String request) {
        this.requestId = requestId;
        this.request = request;
        loadFXML();
    }

    private void loadFXML() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("RequestSection.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    public int getRequestId() {
        return requestId;
    }

    public String getRequest() {
        return request;
    }
}
