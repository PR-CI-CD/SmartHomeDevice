public abstract class SmartDevice {

    protected String name;
    protected boolean isOn;

    public SmartDevice(String name) {
        this.name = name;
        this.isOn = false;
    }

    public void turnOn() {
        isOn = true;
        System.out.println(name + " is now ON");
    }

    public void turnOff() {
        isOn = false;
        System.out.println(name + " is now OFF");
    }

    public String getStatus() {
        return name + " - " + (isOn ? "ON" : "OFF");
    }

    public String getName() {
        return name;
    }
}