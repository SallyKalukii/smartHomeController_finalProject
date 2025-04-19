// a smart door device in the home
public class SmartDoor implements Device {
    private String roomName;    // The room/door where this door is located
    private boolean isLocked;   // Current lock state of the door

    // Creating a new smart door for the specified location
    public SmartDoor(String roomName) { 
        this.roomName = roomName; 
        this.isLocked = true; // Door starts in locked state for security
    }

    @Override
    public void turnOn() {
        isLocked = true; // Locking the door
    }
    
    @Override
    public void turnOff() {
        isLocked = false; // Unlocking the door
    }
    
    @Override
    public boolean getStatus() {
        return isLocked; // Returns true if locked, false if unlocked
    }
    
    @Override
    public String getDescription() {
        return this.roomName + " Smart Door is " + (isLocked ? "LOCKED" : "UNLOCKED");
    }
    
    @Override
    public String getRoomName() {
        return this.roomName;
    }
} 