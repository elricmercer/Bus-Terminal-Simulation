package apbt.pkg3;

public class Passanger extends Thread
{
    String name;
    int dest, gateC, ticketCountC;
    boolean buyTicket, checkTicket;
    Entrance e;
    TicketCounter t;
    Boarding b;
    Destination d;

    public Passanger(String name, int dest, int gateC, int ticketCountC, boolean buyTicket, boolean checkTicket, Entrance e, TicketCounter t, Boarding b, Destination d)
    {
        this.name = name;
        this.dest = dest;
        this.gateC = gateC;
        this.ticketCountC = ticketCountC;
        this.buyTicket = buyTicket;
        this.checkTicket = checkTicket;
        this.e = e;
        this.t = t;
        this.b = b;
        this.d = d;
    }
    
    public void run()
    {
        switch(gateC)
        {
            case 0: e.westEntrance(this);
            break;
            case 1: e.eastEntrance(this);
            break;
            default: System.out.println("ERROR...!");
        }
    }
}
