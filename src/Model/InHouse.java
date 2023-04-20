package Model;

/**
 *
 * @author scott
 */
public class InHouse extends Part{

    // Declare Fields
    private int machineId;

    // Declare Methods

    /**
     *
     * @param id
     * @param name
     * @param price
     * @param stock
     * @param min
     * @param max
     * @param machineID
     */
    public InHouse(int id, String name, double price, int stock, int min, int max, int machineID){
        super(id, name, price, stock, min, max);
        this.machineId = machineID;
    }

    /**
     *
     * @returnm machine id
     */
    public int getMachineId() {
        return machineId;
    }

    /**
     *
     * @param machineId to set
     */
    public void setMachineId(int machineId) {
        this.machineId = machineId;
    }
}
