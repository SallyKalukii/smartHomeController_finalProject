// Creating a single center of control for the home using singleton pattern which ensures that only one instance exist

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SmartHomeController {
    private static SmartHomeController instance; // Singleton instance
    private List<ActionObserver> observers;
    private List<Room> rooms;
    private Map<String, AutomationMode> automationModes;
    
    // Private constructor for singleton pattern
    private SmartHomeController() {
        this.observers = new ArrayList<>();
        this.rooms = new ArrayList<>();
        this.automationModes = new HashMap<>();
    }
    
    // Getting the singleton instance
    public static SmartHomeController getInstance() {
        if (instance == null) {
            instance = new SmartHomeController();
        }
        return instance;
    }
    
    // Adding observers to notify me with the device changes using logs. This is where the oserver pattern comes in. 
    public void addObserver(ActionObserver observer) {
        if (observer != null) {
            observers.add(observer);
        }
    }
    
    // Controlling a device and notifying observers
    public void controlDevice(Device device, boolean turnOn) {
        if (device == null) {
            System.out.println("Error: Cannot control null device");
            return;
        }
        
        if (turnOn) {
            device.turnOn();
        } else {
            device.turnOff();
        }
        
        // Notifying all th observers
        for (ActionObserver observer : observers) {
            observer.update(device, device.getStatus());
        }
    }
    
    // Adding a room to the controller
    public void addRoom(Room room) {
        if (room != null) {
            rooms.add(room);
        }
    }
    
    // Getting all rooms
    public List<Room> getRooms() {
        return new ArrayList<>(rooms);
    }
    
    // Registering automation modes for later implementations. This is where the strategy pattern comes in 
    public void registerAutomationMode(String name, AutomationMode mode) {
        if (name != null && mode != null) {
            automationModes.put(name, mode);
        }
    }
    
    // Executing an automation mode ,either vacation or night mode
    public void executeAutomationStrategy(String name) {
        AutomationMode mode = automationModes.get(name);
        if (mode != null) {
            mode.execute(rooms);
        } else {
            System.out.println("Automation mode not found: " + name);
        }
    }
    
    // Finding a room by name
    public Room findRoomByName(String name) {
        if (name == null) {
            return null;
        }
        
        for (Room room : rooms) {
            if (room.getName().equalsIgnoreCase(name)) {
                return room;
            }
        }
        return null;
    }
}
    


