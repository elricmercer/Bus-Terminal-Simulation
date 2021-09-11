package apbt.pkg4;

import java.util.concurrent.Semaphore;

public class Passanger extends Thread
{
    String name;
    int gateCh, ticketCh;
    Semaphore no;
    TicketInfo ti;
    TerminalSimulation ts;

    public Passanger(String name, int gateCh, int ticketCh, Semaphore no, TicketInfo ti, TerminalSimulation ts)
    {
        this.name = name;
        this.gateCh = gateCh;
        this.ticketCh = ticketCh;
        this.no = no;
        this.ti = ti;
        this.ts = ts;
    }
    
    public void run()
    {
        try
        {
            Thread.sleep(1000);
            no.acquire(1);
            if(gateCh==0)
                System.out.println("Passenger No. "+name+" entered through east gate");
            else if(gateCh==1)
                System.out.println("Passenger No. "+name+" entered through west gate");
            ts.ticket(this);
        }
        catch(Exception e)
        {

        }
    }
}
