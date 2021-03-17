package C_JavaAdvanced.JavaAdv.StacksAndQueues;

import java.util.*;

public class Robotics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputRobots = scanner.nextLine().split(";");

        Map<String, Integer> robots = splitRobotsDataIntoLinkedHashMap(inputRobots);


        int[] processTime = new int[robots.size()];

        String[] time = scanner.nextLine().split(":");

        int hours = Integer.parseInt(time[0]);
        int minutes = Integer.parseInt(time[1]);
        int seconds = Integer.parseInt(time[2]);

        long totalSeconds = (hours * 3600) + (minutes * 60) + seconds;

        Deque<String> products = new ArrayDeque<>();

        String line = scanner.nextLine();

        while (!"End".equals(line)) {
            products.add(line);
            line = scanner.nextLine();
        }
        while (!products.isEmpty()) {
            totalSeconds++;

            String current = products.poll();

            decreaseProcessTime(processTime);

            if (!assignJob(robots, processTime, current, totalSeconds)) {
                products.offer(current);
            }

        }
    }

    private static void decreaseProcessTime(int[] processTime) {
        for (int i = 0; i < processTime.length; i++) {
            if (processTime[i] > 0) {
                --processTime[i];
            }
        }
    }

    public static boolean assignJob(Map<String, Integer> robots, int[] processTime, String current, long totalSeconds) {
        for (int i = 0; i < processTime.length; i++) {
            if (processTime[i] == 0) {
                int count = 0;
                for (Map.Entry<String, Integer> entry : robots.entrySet()) {
                    if (count == i) {
                        processTime[i] = entry.getValue();
                        logJobAssigned(entry.getKey(), current, totalSeconds);
                        return true;
                    }
                    count++;
                }

            }
        }
        return false;
    }

    private static void logJobAssigned(String name, String product, long totalSeconds) {
        long hours = (totalSeconds / 3600 ) % 24;
        long minutes = ((totalSeconds % 3600) / 60);
        long seconds = (totalSeconds % 60);



        System.out.println(String.format("%s - %s [%02d:%02d:%02d]", name, product,hours,minutes,seconds) );

    }

    private static Map<String, Integer> splitRobotsDataIntoLinkedHashMap(String[] inputRobots) {
        Map<String, Integer> robots = new LinkedHashMap<>();

        for (int i = 0; i < inputRobots.length; i++) {
            String line = inputRobots[i];
            int index = line.indexOf("-");

            String name = line.substring(0, index);
            int time = Integer.parseInt(line.substring(index + 1));
            robots.put(name, time);
        }

        return robots;
    }
}
