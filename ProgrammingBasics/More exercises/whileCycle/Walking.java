package A_PB.pastLectures.whileCycle;

import java.util.Scanner;

public class Walking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int goal = 10000;
        int steps = 0;
        String input = scanner.nextLine();
        while (steps < goal){
            if (!input.equals("Going home")){
                int inputToSteps = Integer.parseInt(input);
                steps = steps + inputToSteps;
                if(steps >= goal){
                    System.out.printf("Goal reached! Good job!");
                    break;
                }
                input = scanner.nextLine();
            }else if (input.equals("Going home")){
                input = scanner.nextLine();
                int inputToSteps = Integer.parseInt(input);
                steps = steps + inputToSteps;
                if(steps >= goal){
                    System.out.printf("Goal reached! Good job!");
                    break;
                }else {
                    System.out.printf("%d more steps to reach goal.", (goal - steps));
                    break;
                }
            }
        }
    }
}
