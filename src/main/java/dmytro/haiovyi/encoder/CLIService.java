package dmytro.haiovyi.encoder;

import java.util.Scanner;

public class CLIService implements ICLIService {
    @Override
    public String readStringLine(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message + ":");
        return scanner.nextLine();
    }

    @Override
    public void printMessage(String message) {
        System.out.println(message);
    }
}
