import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        SmartHomeController controller = new SmartHomeController();

        ArrayList<SmartDevice> devices = new ArrayList<>();

        devices.add(DeviceFactory.createDevice("light", "Living Room Light"));
        devices.add(DeviceFactory.createDevice("light", "Kitchen Light"));
        devices.add(DeviceFactory.createDevice("thermostat", "Main Thermostat"));

        boolean running = true;

        while (running) {

            System.out.println("\n=== SMART HOME SYSTEM ===");

            System.out.println("1. View Devices");
            System.out.println("2. Turn Device ON");
            System.out.println("3. Turn Device OFF");
            System.out.println("4. Set Thermostat Temperature");
            System.out.println("5. Exit");

            System.out.print("\nChoose option: ");

            int choice = scanner.nextInt();

            switch (choice) {

                case 1:

                    System.out.println("\n--- DEVICE STATUS ---");

                    for (int i = 0; i < devices.size(); i++) {
                        System.out.println(i + ": " + devices.get(i).getStatus());
                    }

                    break;

                case 2:

                    System.out.println("\nSelect device to turn ON:");

                    for (int i = 0; i < devices.size(); i++) {
                        System.out.println(i + ": " + devices.get(i).getName());
                    }

                    int onChoice = scanner.nextInt();

                    Command turnOn =
                            new TurnOnCommand(devices.get(onChoice));

                    controller.runCommand(turnOn);

                    break;

                case 3:

                    System.out.println("\nSelect device to turn OFF:");

                    for (int i = 0; i < devices.size(); i++) {
                        System.out.println(i + ": " + devices.get(i).getName());
                    }

                    int offChoice = scanner.nextInt();

                    Command turnOff =
                            new TurnOffCommand(devices.get(offChoice));

                    controller.runCommand(turnOff);

                    break;

                case 4:

                    System.out.println("\nSelect thermostat:");

                    for (int i = 0; i < devices.size(); i++) {

                        if (devices.get(i) instanceof Thermostat) {
                            System.out.println(i + ": " + devices.get(i).getName());
                        }
                    }

                    int thermoChoice = scanner.nextInt();

                    System.out.print("Enter temperature: ");

                    int temp = scanner.nextInt();

                    if (devices.get(thermoChoice) instanceof Thermostat) {

                        Thermostat thermostat =
                                (Thermostat) devices.get(thermoChoice);

                        thermostat.setTemperature(temp);
                    }

                    break;

                case 5:

                    running = false;

                    System.out.println("\nExiting Smart Home System...");

                    break;

                default:

                    System.out.println("Invalid option.");
            }
        }

        scanner.close();
    }
}
