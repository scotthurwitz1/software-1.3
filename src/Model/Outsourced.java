package Model;

public class Outsourced extends Part{

    // Declare Fields
    private String companyName;

    // Declare Methods
    Outsourced(int id, String name, double price, int stock, int min, int max, String companyName){
        super(id, name, price, stock, min, max);
        this.companyName = companyName;
    }
    public void setCompanyName(String companyName){}
    public String getCompanyName(){
        return companyName;
    };
}