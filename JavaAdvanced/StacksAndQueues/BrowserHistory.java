package C_JavaAdvanced.JavaAdv.StacksAndQueues;
import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> stack = new ArrayDeque<>();

        String input =  scanner.nextLine();
        while (!"Home".equals(input)) {

            if (input.equals("back")) {
                if (stack.size() <=1 ) {
                    System.out.println("no previous URLs");
                } else {
                    stack.pop();
                    System.out.println(stack.peek());
                }
            }else{
                stack.push(input);
            }
            if (!input.equals("back")) {
                System.out.println(input);
            }

            input = scanner.nextLine();
        }
    }
}
