public class MP3 extends Gadget {
    
    private int memory;
    
    public MP3(String model, double price, int weight, String size, int memory) {
        super(model, price, weight, size);
        this.memory = memory;
    }
    
    public int getMemory() {
        return memory;
    }
    
    public void downloadMusic(int size) {
        if (size <= 0) {
            System.out.println("Invalid download size.");
            return;
        }
        
        if (memory >= size) {
            memory -= size;
            System.out.println("Downloaded! Remaining memory: " + memory);
        } else
        {
            System.out.println("Not enough memory.");
        }
    }
    
    public void deleteMusic(int size) {
        memory += size;
        System.out.println("Deleted files. Memory now: " + memory);
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Available memory: " + memory + "MB");
    }
}