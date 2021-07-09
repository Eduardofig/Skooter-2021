import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String s;
        Scanner scan = new Scanner(System.in);
        Subject subj = new Subject();
        subj.addObserver(new ObserverConcatSize());
        subj.addObserver(new ObserverConcatYear());
        subj.addObserver(new ObserverUpperCase());

        while(true) {
            s = scan.nextLine();
            if(s.equals("exit")) {
                scan.close();
                System.exit(0);
            }
            subj.sendNewString(s);
        }
    }
}
