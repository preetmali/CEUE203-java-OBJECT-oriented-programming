public class Driver2 {
    public static void main(String[] args) {

        Media[] media = {
                new Book("Java Programming", 3),
                new DVD("Avengers", 2),
                new Magazine("Tech Today", 4),
                new Book("Data Structures", 5)
        };

        double total = 0;

        for (Media m : media) {

            double fee = m.lateFee();

            System.out.println(
                    m.title + " - Late Fee: " + fee);

            total += fee;
        }

        System.out.println("Total Late Fees: " + total);
        System.out.println("25CE057");

    }
}