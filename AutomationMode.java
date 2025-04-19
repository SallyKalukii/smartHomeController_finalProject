// Using strategy pattern to differenciate automation strategies that can be applied to the smart home
import java.util.List;

public interface AutomationMode {
    /**
     * @param rooms The list of rooms to apply the automation strategy to
     */
    void execute(List<Room> rooms);
}
