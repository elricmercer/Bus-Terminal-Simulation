package apbt;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class WestEastEntrance
{
    TicketCounter t;
    Employee em;
    
    int passangers = 0;
    String emp="";
    
    Lock l = new ReentrantLock();
    
    synchronized public void westEntrance(Passangers p)
    {
        if(em.type==2)
            emp = "Guard";
        l.lock();
        while(passangers<=70)
        {
            System.out.println(emp+" "+em.name+" allows passanger: "+p.name+" to enter");
            try
            {
                Thread.sleep(100);
            }
            catch(Exception e)
            {
                
            }
            passangers++;
            l.unlock();
            switch(p.tCh)
            {
                case 1: t.ticketCounter_1(p);
                break;
                case 2: t.ticketCounter_2(p);
                break;
                case 3: t.ticketMachine(p);
                break;
                default: System.out.println("ERROR.....!");
            }
        }
    }
    
    synchronized public void eastEntrance(Passangers p)
    {
        if(em.type==2)
            emp = "Guard";
        l.lock();
        while(passangers<=70)
        {
            try
            {
                Thread.sleep(100);
            }
            catch(Exception e)
            {
                
            }
            System.out.println(emp+" "+em.name+" allows passanger: "+p.name+" to enter");
            passangers++;
            l.unlock();
            switch(p.tCh)
            {
                case 1: t.ticketCounter_1(p);
                break;
                case 2: t.ticketCounter_2(p);
                break;
                case 3: t.ticketMachine(p);
                break;
                default: System.out.println("ERROR.....!");
            }
        }
    }
}
