//Test Class

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Getting the singleton controller instance 
        SmartHomeController controller = SmartHomeController.getInstance();
        
        // Creating and registering observer
        LoggingObserver logger = new LoggingObserver();
        controller.addObserver(logger);
        
        // Create device factory
        DeviceFactory deviceFactory = new DeviceFactory();
        
        // Create rooms and devices
        setupHomeEnvironment(controller, deviceFactory);
        
        // Register automation modes
        controller.registerAutomationMode("night", new NightMode());
        controller.registerAutomationMode("vacation", new VacationMode());
        
        // Simple menu
        menu(controller);
    }
    
    private static void setupHomeEnvironment(SmartHomeController controller, DeviceFactory factory) {
        // Living Room
        Room livingRoom = new Room("Living Room");
        livingRoom.addDevice(factory.createDevice("light", "Living Room"));
        livingRoom.addDevice(factory.createDevice("airconditioner", "Living Room"));
        livingRoom.addDevice(factory.createDevice("smartdoor", "Front Door"));
        controller.addRoom(livingRoom);
        
        // Kitchen
        Room kitchen = new Room("Kitchen");
        kitchen.addDevice(factory.createDevice("light", "Kitchen"));
        kitchen.addDevice(factory.createDevice("airconditioner", "Kitchen"));
        controller.addRoom(kitchen);
        
        // Bathroom
        Room bathroom = new Room("Bathroom");
        bathroom.addDevice(factory.createDevice("light", "Bathroom"));
        bathroom.addDevice(factory.createDevice("smartdoor", "Bathroom Door"));
        controller.addRoom(bathroom);
    }
    
    private static void menu(SmartHomeController controller) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        
        while (running) {
            System.out.println("Welcome to your Smart Home Controller ");
            System.out.println("1. Control all devices in a room");
            System.out.println("2. Control an individual device");
            System.out.println("3. Change automation Modes (Night or Vacation)");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            switch (choice) {
                case 1:
                    controlRoomDevices(controller, scanner);
                    break;
                case 2:
                    controlIndividualDevice(controller, scanner);
                    break;
                case 3:
                    executeAutomationStrategy(controller, scanner);
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
        
        scanner.close();
    }
    
    private static void controlIndividualDevice(SmartHomeController controller, Scanner scanner) {
        // List all rooms
        System.out.println("\nAvailable Rooms:");
        for (Room room : controller.getRooms()) {
            System.out.println("- " + room.getName());
        }
        
        System.out.print("Enter room name: ");
        String roomName = scanner.nextLine();
        
        Room selectedRoom = controller.findRoomByName(roomName);
        if (selectedRoom == null) {
            System.out.println("Room not found!");
            return;
        }
        
        // List devices in room
        System.out.println("\nDevices in " + selectedRoom.getName() + ":");
        int i = 1;
        for (Device device : selectedRoom.getDevices()) {
            System.out.println(i + ". " + device.getDescription() + " - " + 
                    (device.getStatus() ? "ON" : "OFF"));
            i++;
        }
        
        System.out.print("Enter device number: ");
        int deviceNum = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        if (deviceNum < 1 || deviceNum > selectedRoom.getDevices().size()) {
            System.out.println("Invalid device selection!");
            return;
        }
        
        Device selectedDevice = selectedRoom.getDevices().get(deviceNum - 1);
        
        System.out.print("Turn on? (yes/no): ");
        String turnOn = scanner.nextLine();
        
        controller.controlDevice(selectedDevice, turnOn.equalsIgnoreCase("yes"));
    }
    
    private static void controlRoomDevices(SmartHomeController controller, Scanner scanner) {
        // List all rooms
        System.out.println("\nAvailable Rooms:");
        for (Room room : controller.getRooms()) {
            System.out.println("- " + room.getName());
        }
        
        System.out.print("Enter room name: ");
        String roomName = scanner.nextLine();
        
        Room selectedRoom = controller.findRoomByName(roomName);
        if (selectedRoom == null) {
            System.out.println("Room not found!");
            return;
        }
        
        System.out.print("Turn all devices on? (yes/no): ");
        String turnOn = scanner.nextLine();
        
        selectedRoom.controlAllDevices(turnOn.equalsIgnoreCase("yes"));
    }
    
    private static void executeAutomationStrategy(SmartHomeController controller, Scanner scanner) {
        System.out.println("\nAvailable Strategies:");
        System.out.println("1. Night Mode");
        System.out.println("2. Vacation Mode");
        
        System.out.print("Enter choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        switch (choice) {
            case 1:
                controller.executeAutomationStrategy("night");
                break;
            case 2:
                controller.executeAutomationStrategy("vacation");
                break;
            default:
                System.out.println("Invalid strategy selection!");
        }
    }
}