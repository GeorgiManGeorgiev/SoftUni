package harvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Field[] fields = RichSoilLand.class.getDeclaredFields();
        while (!input.equals("HARVEST")) {
            for (Field field : fields) {
                int modifier = field.getModifiers();
                String modToString = Modifier.toString(modifier);
                if (modToString.equals(input)||input.equals("all"))
                System.out.println(String.format("%s %s %s", modToString
                        , field.getType().getSimpleName(), field.getName()));

            }
            input = scanner.nextLine();

        }
    }
}
