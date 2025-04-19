// This class implements the ActionObserver interface to log device state changes
import java.util.ArrayList;
import java.util.List;

public class LoggingObserver implements ActionObserver {
    private List<String> log; // Stores all the log entries
    
    // Creating a new logging observer with an empty log
    public LoggingObserver() {
        this.log = new ArrayList<>();
    }
    
    @Override
    public void update(Device device, boolean status) {
        // Converting status to appropriate text based on device type
        String statusText = status ? "ON" : "OFF";
        if (device.getClass().getSimpleName().equals("SmartDoor")) {
            statusText = status ? "LOCKED" : "UNLOCKED";
        }
        
        // Creating and storing the log entry
        String entry = device.getDescription() + " turned " + statusText;
        log.add(entry);
        System.out.println("LOG: " + entry);
    }
    
    // Getting a copy of all log entries
    public List<String> getLog() {
        return new ArrayList<>(log);
    }
} 