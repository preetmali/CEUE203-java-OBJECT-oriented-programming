public class EmailNotifier implements Notifier, Urgent {

    @Override
    public void send(String message) {
        System.out.println("Email: " + message);
    }
}