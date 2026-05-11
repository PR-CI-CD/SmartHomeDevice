public class Thermostat extends SmartDevice {

    private int temperature;

    public Thermostat(String name) {
        super(name);
        this.temperature = 20;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
        System.out.println(name + " temperature set to " + temperature + "°C");
    }

    @Override
    public String getStatus() {
        return name + " - " + (isOn ? "ON" : "OFF") +
                " | Temperature: " + temperature + "°C";
    }
}
