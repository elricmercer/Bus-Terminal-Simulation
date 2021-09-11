package apbt.pkg3;

import java.util.Random;

public class MainClass 
{

    public static void main(String[] args)
    {
        int dest,gateC,ticketCountC;
        Entrance en = new Entrance();
        TicketCounter tc = new TicketCounter();
        Boarding br = new Boarding();
        Destination ds = new Destination();
        Passanger p[] = new Passanger[150];
        for(int i=0;i<p.length;i++)
        {
            dest = new Random().nextInt(3);
            gateC = new Random().nextInt(2);
            ticketCountC = new Random().nextInt(3);
            p[i] = new Passanger("Cust-"+Integer.toString(i+1),dest,gateC,ticketCountC,false,false,en,tc,br,ds);
        }
        for(int i=0;i<p.length;i++)
        {
            p[i].start();
        }
    }
}
