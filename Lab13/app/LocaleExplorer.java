package app;

import com.NewClass;

import java.io.IOException;
import java.util.Scanner;

public class LocaleExplorer {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String command;
        NewClass newClass = new NewClass();

        label:
        while(true)
        {
            System.out.println(newClass.getPrompt());
            command = scanner.nextLine();
            command = command.split("\n")[0];
            switch (command) {
                case "Info":
                    newClass.info();
                    break;
                case "SetLocale":
                    String[] arguments = command.split(" ", 2);
                    newClass.setLocale(arguments[1], arguments[2]);
                    break;
                case "DisplayLocales":
                    newClass.displayLocales();
                    break;
                case "Exit":
                    break label;
                default:
                    System.out.println("Unknown command");
                    break;
            }
        }
    }
}
