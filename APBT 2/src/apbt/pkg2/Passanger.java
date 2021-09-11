package apbt.pkg2;

public class Passanger extends Thread
{
    String name;
    boolean ticketBought, ticketChecked;
    int gateC, countC,dest;
    Employee inspector,tt1,tt2,guard1,guard2;

    public Passanger(String name, boolean ticketBought, boolean ticketChecked, int gateC, int countC, int dest) 
    {
        this.name = name;
        this.ticketBought = ticketBought;
        this.ticketChecked = ticketChecked;
        this.gateC = gateC;
        this.countC = countC;
        this.dest = dest;
    }
    
    public void run()
    {
        switch(gateC)
        {
            case 0: 
        }
    }
}
