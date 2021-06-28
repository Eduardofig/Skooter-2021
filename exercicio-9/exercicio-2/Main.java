import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str;
        ArrayList<JanelaThread> threads = new ArrayList<JanelaThread>();
        while(true) {
            str = scanner.nextLine();
            switch(str) {
                case "new":
                    threads.add(new JanelaThread());
                    break;
                default:
                    scanner.close();
                    System.exit(0);
            }
        }
    }
}
