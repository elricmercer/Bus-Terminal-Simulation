package apbt.pkg5;

import java.util.concurrent.Semaphore;

public class Passanger extends Thread
{
    String name;
    int gateCh, ticketCh;
    Semaphore no;
    TicketData td;
    TheSimulation s;

    public Passanger(String name, int gateCh, int ticketCh, Semaphore no, TicketData td, TheSimulation s)
    {
        this.name = name;
        this.gateCh = gateCh;
        this.ticketCh = ticketCh;
        this.no = no;
        this.td = td;
        this.s = s;
    }
    
    public void run()
    {
        try
        {
            Thread.sleep(1000);
            no.acquire(1);
            if(gateCh==0)
                System.out.println("Passanger No "+name+" entered through east gate");
            else if(gateCh==1)
                System.out.println("Passanger No "+name+" entered through west gate");
            s.ticket(this);
        }
        catch(Exception e)
        {

        }
    }
}
