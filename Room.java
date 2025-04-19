import java.util.ArrayList;
import java.util.List;

public class Room {
    private String name;
    private List<Device> devices;
    
    //public constructor
    public Room(String name) { 
        this.name = name; 
        this.devices = new ArrayList<>();
    }
    //method to get the room name 
    public String getName(){
        return name;
    }
    //method to add a device in a room 
    public void addDevice(Device device) {
        devices.add(device);
    }
    //method that returns a copy of the list 
    public List<Device> getDevices() {
        return new ArrayList<>(devices); 
    }

    //turning all the devices on in a room
    public void turnAllOn() {
        for (Device device : devices) {
            device.turnOn();
        }
    }

    //turning all the devices off in a room
    public void turnAllOff() {
        for (Device device : devices) {
            device.turnOff();
        }
    }
    
    //method for controlling all the devices 
    public void controlAllDevices(boolean turnOn) {
        SmartHomeController controller = SmartHomeController.getInstance();
        for (Device device : devices) {
            controller.controlDevice(device, turnOn);
        }
    }

    // Finding a device by type 
    public Device findDeviceByType(String type) {
        for (Device device : devices) {
            if (device.getClass().getSimpleName().equalsIgnoreCase(type)) {
                return device;
            }
        }
        return null;
    }
}