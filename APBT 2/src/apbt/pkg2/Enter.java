package apbt.pkg2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Enter 
{
    int passng = 0;
    
    Lock l = new ReentrantLock();
    TicketCounter t;
    
    synchronized public void westEntrance(Passanger p)
    {
        l.lock();
        System.out.println(p.guard1.title+" is at West Entrance");
        try
        {
            Thread.sleep(100);
        }
        catch(Exception e)
        {
            
        }
        while(passng<=70)
        {
            passng++;
            l.unlock();
            switch(p.countC)
            {
                case 0: t.ticketCounter_1(p);
                break;
                case 1: t.ticketCounter_2(p);
                break;
                case 2: t.ticketMachine(p);
                break;
                default: System.out.println("ERROR.....!");
            }
        }
    }
    
    synchronized public void eastEntrance(Passanger p)
    {
        l.lock();
        System.out.println(p.guard2.title+" is at East Entrance");
        try
        {
            Thread.sleep(100);
        }
        catch(Exception e)
        {
            
        }
        while(passng<=70)
        {
            passng++;
            l.unlock();
            switch(p.countC)
            {
                case 0: t.ticketCounter_1(p);
                break;
                case 1: t.ticketCounter_2(p);
                break;
                case 2: t.ticketMachine(p);
                break;
                default: System.out.println("ERROR....!");
            }
        }
    }
}
