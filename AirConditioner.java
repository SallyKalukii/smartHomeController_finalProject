//smart air conditioner device in the home
public class AirConditioner implements Device {
    private boolean isOn;        // Current power state
    private String roomName;     // The room where this AC is located
    private int temperature;     // Current temperature setting
    
    // Creating a new air conditioner in the specified room
    public AirConditioner(String roomName) {
        this.isOn = false;      // AC starts in off state
        this.temperature = 70;   // Default temperature in Fahrenheit
        this.roomName = roomName;
    }
    
    @Override
    public void turnOn() {
        isOn = true; // Turning the AC on
    }
    
    @Override
    public void turnOff() {
        isOn = false; // Turning the AC off
    }
    
    @Override
    public boolean getStatus() {
        return this.isOn;
    }
    
    // Setting the desired temperature
    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }
    
    // Getting the current temperature setting
    public int getTemperature() {
        return this.temperature;
    }
    
    @Override
    public String getDescription() {
        return roomName + " Air Conditioner is " + (isOn ? "ON" : "OFF") + 
               " and set to " + temperature + "°F";
    }
    
    @Override
    public String getRoomName() {
        return roomName;
    }
} 