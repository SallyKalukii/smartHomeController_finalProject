public class DeviceFactory {

    //creating different devices using factory pattern
    public Device createDevice(String type, String roomName) {
        switch (type.toLowerCase()) {
            case "light": //device one 
                return new Light(roomName);
            case "airconditioner": //device two
                return new AirConditioner(roomName);
            case "smartdoor": //device three 
                return new SmartDoor(roomName);
            default: //error handling 
                throw new IllegalArgumentException("Unknown device type: " + type);
        }
    }
}