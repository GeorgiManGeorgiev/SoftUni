package B_FM.RegEx;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WinningTicket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tickets = scanner.nextLine().split("\\s*,\\s+");

        String regex = "[^@#$^]*(?<one>[@#$^]{6,10})[^@#$^]*(\\1)[^@#$^]*";
        Pattern pattern = Pattern.compile(regex);


        for (int i = 0; i <tickets.length ; i++) {
            String currTicket = tickets[i];
            if (currTicket.length()==20){
                Matcher matcher = pattern.matcher(currTicket);
                if (!matcher.find()){
                    System.out.println(String.format("ticket \"%s\" - no match",currTicket));
                }else {
                 String winingSeq = matcher.group("one");
                 char winChar = winingSeq.charAt(0);
                 int winSeqLength = winingSeq.length();
                    if (winSeqLength==10){
                        System.out.println(String.format( "ticket \"%s\" - %d%c Jackpot!",currTicket,winSeqLength,winChar));
                    }else {
                        System.out.println(String.format("ticket \"%s\" - %d%c",currTicket,winSeqLength,winChar));
                    }
                }
            }else {
                System.out.println("invalid ticket");
            }

        }
    }
}
