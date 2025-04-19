// Implementing night-time automation mode
import java.util.List;

public class NightMode implements AutomationMode {
    @Override
    public void execute(List<Room> rooms) {
        SmartHomeController controller = SmartHomeController.getInstance();
        System.out.println("Executing Night Mode...");
        
        // Turning off all lights
        for (Room room : rooms) {
            for (Device device : room.getDevices()) {
                if (device.getClass().getSimpleName().equals("Light")) {
                    controller.controlDevice(device, false);
                }
                // Locking all doors
                if (device.getClass().getSimpleName().equals("SmartDoor")) {
                    controller.controlDevice(device, true);
                }
                // Setting thermostats to night temperature
                if (device.getClass().getSimpleName().equals("AirConditioner")) {
                    controller.controlDevice(device, true);
                    ((AirConditioner)device).setTemperature(65);
                }
            }
        }
    }
} 