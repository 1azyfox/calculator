public class MyException extends Exception {
    String message;

    public MyException(String myMessage) {
        message = myMessage;
    }

    public String returnMyMessage() {
        return ("Ошибка - " + message);
    }
}
