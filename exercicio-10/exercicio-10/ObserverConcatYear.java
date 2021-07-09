import java.util.Calendar;

public class ObserverConcatYear extends Observer {
    public void update() {
        this.setString(this.getString() + Calendar.getInstance().get(Calendar.YEAR));
    }
}
