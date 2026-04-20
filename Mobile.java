
/**
 * 
 */
public class Mobile extends Gadget
{
   private int credit;
   
   public Mobile(String mobile, double price, int weight, String size, int credit) {
       super(mobile, price, weight, size);
       this.credit = credit;
    }
    
    public int getCredit() {
        return credit;
    }
    
    public void addCredit(int amount) {
        if (amount > 0) {
            credit += amount;
            System.out.println("Credit added, new balance: " + credit);
        } else
        {
            System.out.println("You need to enter a positive number.");
        }
    }
    
    public void makeCall(String number, int mins) {
        if (mins <= 0) {
            System.out.println("Invalid call duration.");
            return;
        }
        
        if (credit >= mins) {
            System.out.println("Calling " + number + " for " + mins + " mins....");
            credit -= mins;
            System.out.println("Remaining credit: " + credit);
        } else
        {
            System.out.println("Not enough credit to make this call.");
        }
        
    }
    
    @Override
    public void display() {
        super.display();
        System.out.println("Credit left: " + credit + " mins");
    }
}