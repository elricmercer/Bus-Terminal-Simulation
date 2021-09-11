package apbt.pkg3;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Entrance 
{
    int passng = 0;
    
    Lock l = new ReentrantLock();
    
    TicketCounter t;
    
    synchronized public void westEntrance(Passanger p)
    {
        l.lock();
        try
        {
            Thread.sleep(500);
        }
        catch(Exception e)
        {
            
        }
        if(passng<=70)
        {
            System.out.println("Passanger: "+p.name+" entered through west entrance");
            passng++;
            l.unlock();
            switch(p.ticketCountC)
            {
                case 0: t.ticketCounter_1(p);
                break;
                case 1: t.ticketCounter_2(p);
                break;
                case 2: t.ticketMachine(p);
                break;
                default: System.out.println("ERROR...!");
            }
        }
        else
        {
            l.unlock();
            System.out.println("Guard at West Entrance closed entry");
            westEntrance(p);
        }
    }
    
    synchronized public void eastEntrance(Passanger p)
    {
        l.lock();
        try
        {
            Thread.sleep(500);
        }
        catch(Exception e)
        {
            
        }
        if(passng<=70)
        {
            System.out.println("Passanger: "+p.name+" entered through east entrance");
            passng++;
            l.unlock();
            switch(p.ticketCountC)
            {
                case 0: t.ticketCounter_1(p);
                break;
                case 1: t.ticketCounter_2(p);
                break;
                case 2: t.ticketMachine(p);
                break;
                default: System.out.println("ERROR...!");
            }
        }
        else
        {
            l.unlock();
            System.out.println("Guard at East Entrance closed entry");
            eastEntrance(p);
        }
    }
}
