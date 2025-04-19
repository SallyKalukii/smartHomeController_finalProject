// smart light device in the home
public class Light implements Device {
    private String roomName; // The room where this light is located
    private boolean isOn;    // Current state of the light
    
    // Creating a new light in the specified room
    public Light(String roomName) { 
        this.roomName = roomName; 
        this.isOn = false; // Light starts in off state
    }
    
    @Override
    public void turnOn() {
        isOn = true; // Turning the light on
    }
    
    @Override
    public void turnOff() { 
        isOn = false; // Turning the light off
    }
    
    @Override
    public String getRoomName() {
        return this.roomName; 
    }
    
    @Override
    public String getDescription() {
        return this.roomName + " Light is " + (isOn ? "ON" : "OFF");
    }
    
    @Override
    public boolean getStatus() {
        return isOn; 
    }
} 