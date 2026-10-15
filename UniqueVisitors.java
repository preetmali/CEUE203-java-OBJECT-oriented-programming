
import java.util.*;

public class UniqueVisitors {
    public static void main(String[] args) {

        List<String> logins = Arrays.asList(
                "Rahul", "Amit", "Priya", "Rahul",
                "Neha", "Amit", "Karan");

        HashSet<String> uniqueUsers = new HashSet<>();

        LinkedHashSet<String> orderedUsers = new LinkedHashSet<>();

        for (String user : logins) {
            uniqueUsers.add(user);
            orderedUsers.add(user);
        }

        System.out.println("Unique Visitors: " + uniqueUsers.size());

        System.out.println("First Three Distinct Names:");

        int count = 0;

        for (String user : orderedUsers) {
            if (count == 3) {
                break;
            }

            System.out.println(user);
            count++;
        }
        System.out.println("25CE057");
    }
}
