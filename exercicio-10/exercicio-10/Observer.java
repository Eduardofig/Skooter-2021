public abstract class Observer {
    private String sString;

    public void setString(String iString) {
        this.sString = iString;
    }

    public String getString() {
        return this.sString;
    }

    public abstract void update();

    public void updateString(String iString) {
        this.setString(iString);
        this.update();
        System.out.println(this.getString());
    }
}
