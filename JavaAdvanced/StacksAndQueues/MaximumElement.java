package C_JavaAdvanced.JavaAdv.StacksAndQueues;
import java.util.*;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Deque<Long> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            int command  = scanner.nextInt();
            if (command==1){
                long element = scanner.nextLong();
                stack.push(element);
            }
            if (command==2){
                stack.pop();
            }
            if (command==3){
                System.out.println(Collections.max(stack));
            }
        }
    }
}
