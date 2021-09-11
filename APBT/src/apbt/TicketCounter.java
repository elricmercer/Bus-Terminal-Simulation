package apbt;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TicketCounter 
{
    int br,tl;
    String emJob = "";
    
    Boarding b;
    Employee em;
    
    Lock l = new ReentrantLock();
    
    synchronized public void ticketCounter_1(Passangers p)
    {
        l.lock();
        if(em.type==3)
            emJob = "Ticket Personnel";
        int ran = new Random().nextInt(tl);
        try
        {
            Thread.sleep(100);
        }
        catch(Exception e)
        {
                
        }
        if(tl%2==0)
        {
            System.out.println(emJob+" "+em.name+" is on a break, please kindly wait or move to the other counters");
            ran = new Random().nextInt(3);
            switch(ran)
            {
                case 0: 
                {
                    l.unlock();
                    ticketCounter_2(p);
                }
                break;
                case 1: 
                {
                    l.unlock();
                    ticketMachine(p);
                }
                break;
                case 2:
                {
                    try
                    {
                        Thread.sleep(2000);
                        p.buyTicket = true;
                        System.out.println("Passanger: "+p.name+" bought ticket");
                        l.unlock();
                        //b.ticketScanner(p);
                    }
                    catch(Exception e)
                    {
                        
                    }
                }
                default: System.out.println("ERROR...!");
            }
        }
        else
        {
            p.buyTicket = true;
            System.out.println("Passanger: "+p.name+" bought ticket");
            l.unlock();
           // b.ticketScanner(p);
        }
    }
    
    synchronized public void ticketCounter_2(Passangers p)
    {
        l.lock();
        if(em.type==3)
            emJob = "Ticket Personnel";
        int ran = new Random().nextInt(tl);
        try
        {
            Thread.sleep(100);
        }
        catch(Exception e)
        {
                
        }
        if(tl%2==0)
        {
            System.out.println(emJob+" "+em.name+" is on a break, please kindly wait or move to the other counters");
            ran = new Random().nextInt(3);
            switch(ran)
            {
                case 0: 
                {
                    l.unlock();
                    ticketCounter_2(p);
                }
                break;
                case 1: 
                {
                    l.unlock();
                    ticketMachine(p);
                }
                break;
                case 2:
                {
                    try
                    {
                        Thread.sleep(2000);
                        p.buyTicket = true;
                        System.out.println("Passanger: "+p.name+" bought ticket");
                        l.unlock();
                        //b.ticketScanner(p);
                    }
                    catch(Exception e)
                    {
                        
                    }
                }
                default: System.out.println("ERROR...!");
            }
        }
        else
        {
            p.buyTicket = true;
            System.out.println("Passanger: "+p.name+" bought ticket");
            l.unlock();
            //b.ticketScanner(p);
        }
    }
    
    synchronized public void ticketMachine(Passangers p)
    {
        int ran = new Random().nextInt(br);
        try
        {
            Thread.sleep(100);
        }
        catch(Exception e)
        {
                
        }
        if(br%2==0)
        {
            System.out.println("MACHINE FAILURE");
            System.out.println("Passanger: "+p.name+" please move to one of the two ticket counters");
            try
            {
                Thread.sleep(1000);
                ran = new Random().nextInt(2);
                switch(ran)
                {
                    case 0: ticketCounter_1(p);
                    break;
                    case 1: ticketCounter_2(p);
                    break;
                    default: System.out.println("ERROR");
                }
            }
            catch(Exception e)
            {
                
            }
        }
        else
        {
            p.buyTicket = true;
            System.out.println("Passanger: "+p.name+" bought ticket");
            //b.ticketScanner(p);
        }
    }
}
