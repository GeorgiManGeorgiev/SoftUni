package blackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        BlackBoxInt blackBoxInt;
        try {
            Constructor<?> ctor = BlackBoxInt
                    .class.getDeclaredConstructor();
            ctor.setAccessible(true);
            blackBoxInt = (BlackBoxInt) ctor.newInstance();

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            throw new Exception(e);
        }

        Map<String, Method> methodByName =
                Arrays.stream(blackBoxInt.getClass().getDeclaredMethods())
                        .collect(Collectors.toMap(Method::getName, m -> m));

        String input = scanner.nextLine();
        while (!input.equals("END")) {
            String[] tokens = input.split("_");

            String command = tokens[0];
            int param = Integer.parseInt(tokens[1]);

            Method method = methodByName.get(command);
            method.setAccessible(true);
            method.invoke(blackBoxInt, param);

            Field innerValue = blackBoxInt
                    .getClass()
                    .getDeclaredField("innerValue");

            innerValue.setAccessible(true);
            int value =(int) innerValue.get(blackBoxInt);
            System.out.println(value);

            input = scanner.nextLine();
        }
    }
}
