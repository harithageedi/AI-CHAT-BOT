public class ChatBot {

    private ResponseHandler responseHandler;

    public ChatBot() {
        responseHandler = new ResponseHandler();
    }

    public String getResponse(String message) {

        if (message.toLowerCase().startsWith("calculate")) {
            return Calculator.calculate(message);
        }

        return responseHandler.generateResponse(message);
    }
}