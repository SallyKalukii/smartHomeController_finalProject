# Documentation Report

## Design Patterns Used

### 1. Singleton Pattern
- **Implementation**: `SmartHomeController` class
- **Why Used**: Ensures only one instance of the central controller exists, preventing multiple controllers from conflicting with each other and maintaining a single source of truth for the smart home system.

### 2. Factory Pattern
- **Implementation**: `DeviceFactory` class
- **Why Used**: Provides a centralized way to create different types of devices (Light, AirConditioner, SmartDoor) without exposing the creation logic to the client code. Makes it easy to add new device types in the future.

### 3. Observer Pattern
- **Implementation**: `ActionObserver` interface and `LoggingObserver` class
- **Why Used**: Allows the system to notify interested components (like logging systems) whenever a device's state changes, enabling loose coupling between devices and their observers.

### 4. Strategy Pattern
- **Implementation**: `AutomationMode` interface with `NightMode` and `VacationMode` implementations
- **Why Used**: Enables different automation behaviors to be easily swapped at runtime, making the system flexible and extensible for new automation modes.

## Key Classes Explanation

### 1. SmartHomeController
- Central control unit of the smart home system
- Manages all rooms and devices
- Implements the Singleton pattern
- Coordinates between different components

### 2. Device
- Interface defining common behavior for all smart devices
- Implemented by Light, AirConditioner, and SmartDoor
- Provides basic operations like turnOn, turnOff, and status checking

### 3. Room
- Represents a physical room in the house
- Contains multiple devices
- Allows controlling all devices in a room together

### 4. AutomationMode
- Interface for different automation strategies
- Implemented by NightMode and VacationMode
- Defines how devices should behave in different scenarios

## Challenges Faced

1. **Device Type Consistency**
   - Challenge: Maintaining consistent naming between device creation and usage
   - Solution: Implemented case-insensitive device type checking in the factory

2. **State Management**
   - Challenge: Ensuring proper state synchronization across multiple devices
   - Solution: Used Observer pattern to notify all interested parties of state changes

3. **Automation Mode Implementation**
   - Challenge: Making automation modes flexible and easy to extend
   - Solution: Used Strategy pattern to separate automation logic from device control

4. **Error Handling**
   - Challenge: Managing device creation and control errors
   - Solution: Implemented proper error messages and null checks throughout the system

5. **Code Organization**
   - Challenge: Maintaining clean and organized code structure
   - Solution: Separated classes into logical packages and followed design patterns

