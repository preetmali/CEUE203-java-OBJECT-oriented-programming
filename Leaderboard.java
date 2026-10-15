
import java.util.*;

public class Leaderboard {
    public static void main(String[] args) {

        Map<String, Integer> scores = new HashMap<>();

        scores.put("Rahul", 90);
        scores.put("Amit", 95);
        scores.put("Priya", 90);
        scores.put("Neha", 85);
        scores.put("Karan", 95);

        List<Map.Entry<String, Integer>> players = new ArrayList<>(scores.entrySet());

        players.sort(
                Comparator.comparingInt(
                        (Map.Entry<String, Integer> e) -> e.getValue()).reversed()
                        .thenComparing(Map.Entry::getKey));

        int topN = 3;

        System.out.println("Top " + topN + " Players:");

        for (int i = 0; i < Math.min(topN, players.size()); i++) {
            Map.Entry<String, Integer> player = players.get(i);

            System.out.println(
                    player.getKey() + " : " + player.getValue());
        }
        System.out.println("25CE057");
    }
}
