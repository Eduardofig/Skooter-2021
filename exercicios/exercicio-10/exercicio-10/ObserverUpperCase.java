public class ObserverUpperCase extends Observer {
    public void update() {
        this.setString(this.getString().toUpperCase());
    }
}
