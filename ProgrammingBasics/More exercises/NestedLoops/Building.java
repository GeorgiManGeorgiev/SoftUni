package A_PB.pastLectures.NestedLoops;

import java.util.Scanner;

public class Building {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int floors = Integer.parseInt(scanner.nextLine());
        int rooms = Integer.parseInt(scanner.nextLine());

        for (int floor = floors; floor >= 1; floor--) {
            char roomChar;
            if (floor == floors) {
                roomChar ='L';
            }else if (floor %2 == 1){
                roomChar ='A';
            }else  {
                roomChar ='O';
            }
            for (int room = 0; room < rooms ; room++) {
                System.out.printf("%c%d%d ",roomChar,floor,room);
            }
            System.out.println();
        }
    }
}
