public class DeviceFactory {

    public static SmartDevice createDevice(String type, String name) {

        if (type.equalsIgnoreCase("light")) {
            return new Light(name);
        }

        if (type.equalsIgnoreCase("thermostat")) {
            return new Thermostat(name);
        }

        return null;
    }
}