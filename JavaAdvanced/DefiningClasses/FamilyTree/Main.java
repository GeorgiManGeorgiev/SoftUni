//package C_JavaAdvanced.JavaAdv.DefiningClasses.FamilyTree;
//
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Scanner;
//
//public class Main {
//    public static void ConsumerPrint(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        String param = scanner.nextLine();
//
//        Person person = new Person();
//
//        if (param.contains("/")) {
//            person.setBirthDate(param);
//        } else {
//            person.setName(param);
//        }
//
//        String line = scanner.nextLine();
//
//        Map<String,String> peopleData = new HashMap<>();
//
//        Map<String,>
//
//        while (!line.equals("End")) {
//
//            if (line.contains(" - ")) {
//                String[] tokens = line.split(" - ");
//                String left = tokens[0];
//                String right = tokens[1];
//
//                if (!left.contains("/")&& !right.contains("/") ){
//                peopleData.putIfAbsent(left,"");
//
//                }else if(!left.contains("/")&& right.contains("/") ){
//
//                } else if(left.contains("/")&& !right.contains("/") ){
//
//                }
//
//            }else {
////                String[] tokens = line.split();
//            }
//
//            line = scanner.nextLine();
//        }
//    }
//}
