package server.context;

import java.util.Scanner;

public class UserInputScanner {

    private static final Scanner SCANNER = new Scanner(System.in);

    public static String scan() {
        return SCANNER.nextLine();
    }

}
