package B_FM.FinalExam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class InboxManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashMap<String, ArrayList<String>> users = new HashMap<>();

        String input = scanner.nextLine();

        while (!"Statistics".equals(input)) {
            String[] tokens = input.split("->");
            String username = tokens[1];
            String command = tokens[0];
            switch (command) {

                case "Add":
                    if (users.containsKey(username)){
                        System.out.println(String.format("%s is already registered",username));
                    }else   {
                        users.put(username,new ArrayList<String>());
                    }

                    break;
                case "Send":
                    String email = tokens[2];
                    ArrayList<String> emails = users.get(username);
                    emails.add(email);
                    break;
                case "Delete":
                if (users.containsKey(username)){
                    users.remove(username);
                }else {
                    System.out.println(String.format("%s not found!",username));
                }
                    break;
            }


            input = scanner.nextLine();
        }
        System.out.println(String.format("Users count: %d",users.size()));
        users
                .entrySet()
                .stream()
                .sorted((u1,u2)->{
                    int result = u2.getValue().size()- u1.getValue().size();
                    if (result==0){
                        result =  u1.getKey().compareTo(u2.getKey());

                    }
                    return result;
                })
                .forEach(u->{
                    System.out.println(u.getKey());
                    u.getValue().forEach(e-> System.out.println(String.format(" - %s",e)));

                });
    }
}
