public class ObserverConcatSize extends Observer {
    public void update() {
        this.setString(this.getString() + String.valueOf(this.getString().length()));
    }
}
