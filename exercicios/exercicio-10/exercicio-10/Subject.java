import java.util.ArrayList;

public class Subject {
    private ArrayList<Observer> observers;

    public void sendNewString(String sString) {
        for(int i = 0; i < observers.size(); ++i) {
            observers.get(i).updateString(sString);
        }
    }

    public void addObserver(Observer obObserver) {
        this.observers.add(obObserver);
    }

    public Subject() {
        this.observers = new ArrayList<Observer>();
    }
}
