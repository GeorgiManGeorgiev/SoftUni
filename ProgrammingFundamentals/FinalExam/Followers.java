package B_FM.FinalExam;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Followers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> comments = new HashMap<>();
        Map<String, Integer> likes = new HashMap<>();


        String input = scanner.nextLine();
        while (!"Log out".equals(input)) {
            String[] tokens = input.split(": ");
            String command = tokens[0];
            String username = tokens[1];

            switch (command) {
                case "New follower":
                    comments.putIfAbsent(username, 0);
                    likes.putIfAbsent(username, 0);
                    break;
                case "Like":
                    Integer currentLikes = likes.get(username);
                    int newLikes = Integer.parseInt(tokens[2]);

                    if (currentLikes != null) {
                        likes.put(username, currentLikes + newLikes);
                    } else {
                        likes.put(username, newLikes);
                        comments.put(username, 0);
                    }
                    break;
                case "Comment":
                    Integer currentComments = comments.get(username);
                    if (currentComments != null) {
                        comments.put(username, currentComments + 1);
                    } else {
                        comments.put(username, 1);
                        likes.put(username, 0);
                    }
                    break;
                case "Blocked":
                    if (comments.containsKey(username)) {
                        comments.remove(username);
                        likes.remove(username);
                    } else {
                        System.out.printf("%s doesn't exist.%n", username);
                    }
                    break;
            }
            input = scanner.nextLine();
        }

        System.out.println(String.format("%d followers", likes.size()));
        likes
                .entrySet()
                .stream()
                .sorted((a, b) -> {
                    int result = b.getValue().compareTo(a.getValue());
                    if (result == 0) {
                        result = a.getKey().compareTo(b.getKey());
                    }
                    return result;
                })
                .forEach(entry -> {
                    String name = entry.getKey();
                    int like = entry.getValue();
                    int comment = comments.get(name);
                    int sum = like + comment;
                    System.out.println(String.format("%s: %d", name, sum));
                });
    }
}
