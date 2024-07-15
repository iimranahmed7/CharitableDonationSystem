/*
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RequestLogger{

    private static final String REQUEST_FILE_PATH = "requests.txt";

    // Method to log a request
    public static void logRequest(Request request) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(REQUEST_FILE_PATH, true))) {
            writer.write(request.getEmail() + "," + request.getName() + "," + request.getMobileNumber() + "," + request.getMessage() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to retrieve all requests
    public static List<Request> getAllRequests() {
        List<Request> requests = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(REQUEST_FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    Request request = new Request(parts[0], parts[1], parts[2], parts[3]);
                    requests.add(request);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return requests;
    }

    public static void main(String[] args) {
        // Example usage:
        // Logging a request
        Request request = new Request("user@example.com", "John Doe", "1234567890", "Please fulfill my request.");
        logRequest(request);

        // Viewing all requests
        List<Request> allRequests = getAllRequests();
        for (Request req : allRequests) {
            System.out.println(req);
        }
    }
}

class Request {
    private String email;
    private String name;
    private String mobileNumber;
    private String message;

    public Request(String email, String name, String mobileNumber, String message) {
        this.email = email;
        this.name = name;
        this.mobileNumber = mobileNumber;
        this.message = message;
    }

    // Getters and setters

    @Override
    public String toString() {
        return "Request{" +
                "email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
*/
