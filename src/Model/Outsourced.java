package Model;

/**
 *
 * @author scott
 */
public class Outsourced extends Part{

    // Declare Fields
    private String companyName;

    // Declare Methods

    /**
     * 
     * @param id 
     * @param name
     * @param price
     * @param stock
     * @param min
     * @param max
     * @param companyName
     */
    public Outsourced(int id, String name, double price, int stock, int min, int max, String companyName){
        super(id, name, price, stock, min, max);
        this.companyName = companyName;
    }

    /**
     *
     * @param companyName to set
     */
    public void setCompanyName(String companyName){}

    /**
     *
     * @return the company name
     */
    public String getCompanyName(){
        return companyName;
    };
}