package B_FM.List;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SoftUniCoursePlanning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> schedule =
                Arrays.stream(scanner.nextLine().split(", "))
                        .collect(Collectors.toList());

        String line = scanner.nextLine();

        while (!line.equals("course start")) {
            String[] tokens = line.split(":");

            String command = tokens[0];


            switch (command) {

                case "Add":
                    addLesson(schedule, tokens[1]);

                    break;
                case "Insert":
                    insertLesson(schedule, tokens[1], Integer.parseInt(tokens[2]));
                    break;
                case "Remove":
                    int index = schedule.indexOf(tokens[1]);
                    if (schedule.remove(tokens[1])) {
                        schedule.remove(tokens[1] + "-Exercise");
                    }
                    break;
                case "Swap":
                    String firstLesson = tokens[1];
                    String secondLesson = tokens[2];
                    swapLessions(schedule, firstLesson, secondLesson);
                    break;
                case "Exercise":
                    String lessonTitle = tokens[1];
                    String exerciseTitle = lessonTitle + "-Exercise";
                    addExercise(schedule, lessonTitle, exerciseTitle);
                    break;
            }

            line = scanner.nextLine();

        }
        for (int i = 0; i < schedule.size(); i++) {

            System.out.println((i + 1) + "." + schedule.get(i));
        }
    }

    private static void addExercise(List<String> schedule,
                                    String lessonTitle,
                                    String exerciseTitle) {
        if (schedule.contains(lessonTitle) && !schedule.contains(exerciseTitle)) {
            int index = schedule.indexOf(lessonTitle);
            schedule.add(index + 1, exerciseTitle);
        } else if (!schedule.contains(lessonTitle)) {
            schedule.add(lessonTitle);
            schedule.add(exerciseTitle);
        }
    }

    private static void swapLessions(List<String> schedule, String firstLesson, String secondLesson) {
        String exerciseOne = firstLesson + "-Exercise";
        String exerciseTwo = secondLesson + "-Exercise";
        if (schedule.contains(firstLesson) && schedule.contains(secondLesson)) {
            int firstIndex = schedule.indexOf(firstLesson);
            int secondIndex = schedule.indexOf(secondLesson);
            String temp = firstLesson;
            schedule.set(firstIndex, secondLesson);
            schedule.set(secondIndex, temp);
        } else {

            if (schedule.contains(exerciseOne) && schedule.contains(exerciseTwo)) {
                swapLessions(schedule, exerciseOne, exerciseTwo);
            }
            if (schedule.contains(exerciseOne)) {
                schedule.remove(exerciseOne);
                schedule.add(schedule.indexOf(firstLesson) + 1, exerciseOne);
            } else if (schedule.contains(exerciseTwo)) {
                schedule.remove(exerciseTwo);
                schedule.add(schedule.indexOf(secondLesson) + 1, exerciseOne);
            }
        }
    }

    private static void insertLesson(List<String> schedule, String lesson, int index) {
        if (!schedule.contains(lesson)) {
            schedule.add(index, lesson);
        }
    }

    private static void addLesson(List<String> schedule, String lesson) {
        if (!schedule.contains(lesson)) {
            schedule.add(lesson);
        }

    }
}
