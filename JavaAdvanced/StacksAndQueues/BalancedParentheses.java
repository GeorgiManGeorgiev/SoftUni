package C_JavaAdvanced.JavaAdv.StacksAndQueues;

import java.util.*;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String parentheses = scanner.nextLine();
        Deque<Character> stack = new ArrayDeque<>();

        String lookUpTable = "{[(";

        boolean areBalanced = true;

        for (int i = 0; i < parentheses.length(); i++) {
            char symbol = parentheses.charAt(i);

            if (lookUpTable.contains(symbol + "")) {
                stack.push(symbol);
            } else {
                if (stack.isEmpty()) {
                    areBalanced = false;
                    break;
                }
                char top = stack.pop();

                if (!(top == '(' && symbol == ')'
                ||top == '{' && symbol == '}'
                ||top == '[' && symbol == ']')){
                areBalanced = false;
                break;
                }
            }
        }

        String output = areBalanced ? "YES" : "NO";

        System.out.println(output);

    }
}