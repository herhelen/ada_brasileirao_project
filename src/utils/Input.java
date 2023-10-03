package src.utils;

import java.util.Scanner;

public class Input {
    public static int getInt(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static String getString(){
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }
}
