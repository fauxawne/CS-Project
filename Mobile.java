
/**
 * 
 */
public class Mobile extends Gadget
{
    private void showError(String message)
    {
        Alert alert = new Alert(Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setContentText(message);
        alert.showAndWait();
    }
    
    private int credit;
    
    public Mobile(String model, double price, int weight, String size, int credit)
    {
        super(model,price,weight,size);
        this.credit = credit;
    }
    
    public int getCredit()
    {
        return credit;
    }
    
    public void addCredit(int amount)
    {
        if (amount > 0)
        {
            credit += amount;
        }
        else
        {
            showError("Invalid credit amount.");
        }
    }
    
    public void makeCall(String number, int duration)
    {
        if (credit >= duration)
        {
            
        }
    }
}