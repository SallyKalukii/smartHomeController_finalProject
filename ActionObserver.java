// Notifies about device changes or updates the observer when the state changes 
// It's part of the Observer pattern used to notify interested people about device actions
public interface ActionObserver {
    /**
     * @param device The device that changed its state
     * @param status The new state of the device 
     */
    void update(Device device, boolean status);
}
