package Model;

public class Outsourced extends Part{

    // Declare Fields
    private static String companyName;

    // Declare Methods
    public Outsourced(int id, String name, double price, int stock, int min, int max, String companyName){
        super(id, name, price, stock, min, max);
        this.companyName = companyName;
    }

    public void setCompanyName(String companyName){}
    public static String getCompanyName(){
        return companyName;
    };
}