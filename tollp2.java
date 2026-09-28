    import java.util.Scanner;

public class tollp2 {

    enum VehicleType {
        BIKE, CAR, TRUCK
    }

    record Vehicle(String number, VehicleType type) {}

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int totalToll = 0;
        int bikeCount = 0, carCount = 0, truckCount = 0;

        System.out.print("Enter Vehicle Number (or done): ");
        String number = sc.next();

        while (!number.equalsIgnoreCase("done")) {

            System.out.print("Enter Vehicle Type (BIKE/CAR/TRUCK): ");
            VehicleType type = VehicleType.valueOf(sc.next().toUpperCase());

            Vehicle v = new Vehicle(number, type);

            int toll = switch (v.type()) {
                case BIKE -> 20;
                case CAR -> 50;
                case TRUCK -> 150;
            };

            totalToll += toll;

            switch (v.type()) {
                case BIKE -> bikeCount++;
                case CAR -> carCount++;
                case TRUCK -> truckCount++;
            }

            System.out.print("Enter Vehicle Number (or done): ");
            number = sc.next();
        }

        System.out.println("Total Toll: " + totalToll);

        if (bikeCount >= carCount && bikeCount >= truckCount)
            System.out.println("Most Frequent: BIKE");
        else if (carCount >= bikeCount && carCount >= truckCount)
            System.out.println("Most Frequent: CAR");
        else
            System.out.println("Most Frequent: TRUCK");

        sc.close();
    }
}