public class Driver1 {
    public static void main(String[] args) {

        Notifier email = message -> System.out.println("Email: " + message);

        Notifier sms = message -> System.out.println("SMS: " + message);

        Notifier[] senders = {
                email,
                sms
        };

        String message = "Exam will start at 10 AM.";

        System.out.println("\nBroadcast:");

        for (Notifier sender : senders) {
            sender.send(message);
        }

        System.out.println("\nUrgent notification:");

        EmailNotifier urgentEmail = new EmailNotifier();
        SMSNotifier normalSMS = new SMSNotifier();

        Notifier[] allSenders = {
                urgentEmail,
                normalSMS
        };

        for (Notifier sender : allSenders) {

            sender.send(message);

            if (sender instanceof Urgent) {
                sender.send(message);
            }
        }
        System.out.println("25CE057");
    }
}