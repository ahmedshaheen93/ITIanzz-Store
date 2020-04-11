package eg.gov.iti.jets.model.dto;

public class ResponeMessage {
    String Message;
    int statusCode;

    public ResponeMessage(String message, int statusCode) {
        Message = message;
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
}
