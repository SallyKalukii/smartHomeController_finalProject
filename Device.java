// operations that all smart home devices have in common. 
public interface Device {
    // Turns the device on for security devices
    void turnOn();
    
    //turns the device off for security purposes 
    void turnOff();
    
    //Gets the current state of the device
    boolean getStatus();
    
    // Gets the name of the room where the device is located
    String getRoomName();
    
    //Gets a description of the device and its current state
    String getDescription();
}

