package apbt;

public class MiniBus extends Thread
{
    int busNumber, busCap;
    boolean available;

    public MiniBus(int busNumber, int busCap, boolean available)
    {
        this.busNumber = busNumber;
        this.busCap = busCap;
        this.available = available;
    }
    
    public void run()
    {
        
    } 
}
