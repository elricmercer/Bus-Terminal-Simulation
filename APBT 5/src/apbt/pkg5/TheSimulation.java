package apbt.pkg5;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TheSimulation
{
    boolean broken = false;
    
    MiniBus mb;
    
    Lock ticL = new ReentrantLock();
    Lock ins = new ReentrantLock();
    
    Semaphore bus1Seat = new Semaphore(12);
    Semaphore bus2Seat = new Semaphore(12);
    Semaphore bus3Seat = new Semaphore(12);
    
    synchronized public void ticket(Passanger p)
    {
        ticL.lock();
        if(p.ticketCh==0)
        {
            try
            {
                Thread.sleep(3000);
            }
            catch(Exception e)
            {
                
            }
            System.out.println("Passanger No "+p.name+" bought ticket from counter 1");
            p.td.status = true;
            int dest = new Random().nextInt(3);
            p.td.destination=dest;
            p.td.busNo=dest;
            ticL.unlock();
            Inspector(p);
        }
        else if(p.ticketCh==1)
        {
            try
            {
                Thread.sleep(3000);
            }
            catch(Exception e)
            {
                
            }
            System.out.println("Passanger No "+p.name+" bought ticket from counter 2");
            p.td.status = true;
            int dest = new Random().nextInt(3);
            p.td.destination=dest;
            p.td.busNo=dest;
            ticL.unlock();
            Inspector(p);
        }
        else if(p.ticketCh==2)
        {
            if(broken)
            {
                try
                {
                    Thread.sleep(1000);
                }
                catch(Exception e)
                {

                }
                System.out.println("Machine is offline, move to one of the counters");
                int ran = new Random().nextInt(2);
                p.ticketCh=ran;
                ticL.unlock();
                ticket(p);
            }
            else
            {
                try
                {
                    Thread.sleep(2000);
                }
                catch(Exception e)
                {

                }
                System.out.println("Passanger No "+p.name+" bought ticket from machine");
                p.td.status = true;
                int dest = new Random().nextInt(3);
                p.td.destination=dest;
                p.td.busNo=dest;
                ticL.unlock();
                Inspector(p);
            }
        }
    }
    synchronized public void Inspector(Passanger p)
    {
        ins.lock();
        System.out.println("Inspector checking Passanger No "+p.name+" ticket");
        try
        {
            Thread.sleep(2000);
        }
        catch(Exception e)
        {

        }
        if(p.td.status==true)
            if(p.td.busNo==p.td.destination)
            {
                System.out.println("Inspector allows Passanger No "+p.name+" through");
                ins.unlock();
                Departure(p);
            }
    }
    synchronized public void Departure(Passanger p)
    {
        if(p.td.destination==0)
        {
            try
            {
                bus1Seat.acquire(1);
                System.out.println("Passanger No "+p.name+" boards bus 1 to north");
                Thread.sleep(1000);
                if(bus1Seat.availablePermits()==0)
                {
                    System.out.println("Bus 1 has left the terminal");
                    p.no.release(12);
                    synchronized(this)
                    {
                        this.notify();
                    }
                    try
                    {
                        mb.wait();
                    }
                    catch(Exception e)
                    {
                        
                    }
                    //Thread.sleep(10000);
                    System.out.println("Bus 1 has arrived at the terminal");
                    bus1Seat.release(12);
                }
            }
            catch(Exception e)
            {
                
            }
        }
        else if(p.td.destination==1)
        {
            try
            {
                bus2Seat.acquire(1);
                System.out.println("Passanger No "+p.name+" boards bus 2 to east");
                Thread.sleep(1000);
                if(bus2Seat.availablePermits()==0)
                {
                    System.out.println("Bus 2 has left the terminal");
                    p.no.release(12);
                    synchronized(this)
                    {
                        this.notify();
                    }
                    try
                    {
                        mb.wait();
                    }
                    catch(Exception e)
                    {
                        
                    }
                    //Thread.sleep(10000);
                    System.out.println("Bus 2 has arrived at the terminal");
                    bus2Seat.release(12);
                }
            }
            catch(Exception e)
            {
                
            }
        }
        else if(p.td.destination==2)
        {
            try
            {
                bus3Seat.acquire(1);
                System.out.println("Passanger No "+p.name+" boards bus 3 to west");
                Thread.sleep(1000);
                if(bus3Seat.availablePermits()==0)
                {
                    System.out.println("Bus 3 has left the terminal");
                    p.no.release(12);
                    synchronized(this)
                    {
                        this.notify();
                    }
                    try
                    {
                        mb.wait();
                    }
                    catch(Exception e)
                    {
                        
                    }
                    //Thread.sleep(10000);
                    System.out.println("Bus 3 has arrived at the terminal");
                    bus3Seat.release(12);
                }
            }
            catch(Exception e)
            {
                
            }
        }
    }
}
