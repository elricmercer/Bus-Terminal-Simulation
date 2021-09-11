package apbt.pkg6;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;

public class Passanger extends Thread
{
    String name;
    int gateCh, ticketCh;
    Semaphore no;
    TicketInfo ti;
    TerminalSimulation ts;
    Lock tk, ins,q;

    public Passanger(String name, int gateCh, int ticketCh, Semaphore no, TicketInfo ti, TerminalSimulation ts, Lock tk, Lock ins, Lock q) 
    {
        this.name = name;
        this.gateCh = gateCh;
        this.ticketCh = ticketCh;
        this.no = no;
        this.ti = ti;
        this.ts = ts;
        this.tk = tk;
        this.ins = ins;
        this.q = q;
    }

    
    
    public void run()
    {
        try
        {   
            //Checking the capacity of the terminal
            if(no.availablePermits()==0)
            {
                System.out.println("TERMINAL AT FULL CAPACITY, please wait...!");
            }
            //Passanger thread being send randomly to the terminal
            int sl = new Random().nextInt(4)+1;
            Thread.sleep(1000*sl);
            no.acquire(1);
            if(gateCh==0)
            {
                System.out.println("Passenger No. "+name+" entered through east gate");
                ts.qQQQ(this);
            }
            else if(gateCh==1)
            {
                System.out.println("Passenger No. "+name+" entered through west gate");
                ts.qQQQ(this);
            }
        }
        catch(Exception e)
        {

        }
    }
}
