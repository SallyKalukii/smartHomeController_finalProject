// Implementing vacation-time automation mode
import java.util.List;

public class VacationMode implements AutomationMode {
    @Override
    public void execute(List<Room> rooms) {
        SmartHomeController controller = SmartHomeController.getInstance();
        System.out.println("Executing Vacation Mode...");
        
        // Simulating random light patterns
        for (Room room : rooms) {
            // Turning off all devices except security
            for (Device device : room.getDevices()) {
                // Locking all of the doors
                if (device.getClass().getSimpleName().equals("SmartDoor")) {
                    controller.controlDevice(device, true);
                } 
                // Turning off the AC when not needed
                else if (device.getClass().getSimpleName().equals("AirConditioner")) {
                    controller.controlDevice(device, false);
                }
                // Turning off lights
                else if (device.getClass().getSimpleName().equals("Light")) {
                    controller.controlDevice(device, false);
                }
            }
        }
    }
} 