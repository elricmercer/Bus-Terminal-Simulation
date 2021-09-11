package apbt.pkg4;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TerminalSimulation
{
    boolean broken = false;
    
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
            System.out.println("Passenger No. "+p.name+" bought ticket from counter 1");
            p.ti.status = true;
            int dest = new Random().nextInt(3);
            p.ti.destination=dest;
            p.ti.busNo=dest;
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
            System.out.println("Passenger No. "+p.name+" bought ticket from counter 2");
            p.ti.status = true;
            int dest = new Random().nextInt(3);
            p.ti.destination=dest;
            p.ti.busNo=dest;
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
                System.out.println("Passenger No. "+p.name+" bought ticket from machine");
                p.ti.status = true;
                int dest = new Random().nextInt(3);
                p.ti.destination=dest;
                p.ti.busNo=dest;
                ticL.unlock();
                Inspector(p);
            }
        }
    }
    
    synchronized public void Inspector(Passanger p)
    {
        ins.lock();
        System.out.println("Passanger No. "+p.name+" scanned ticket");
        try
        {
            Thread.sleep(1000);
        }
        catch(Exception e)
        {

        }
        System.out.println("Inspector checking Passanger No "+p.name+" ticket");
        try
        {
            Thread.sleep(2000);
        }
        catch(Exception e)
        {

        }
        if(p.ti.status==true)
            if(p.ti.busNo==p.ti.destination)
            {
                System.out.println("Inspector allows Passanger No "+p.name+" through");
                ins.unlock();
                Departure(p);
            }
    }
    
    synchronized public void Departure(Passanger p)
    {
        if(p.ti.destination==0)
            bus1(p);
        else if(p.ti.destination==1)
            bus2(p);
        else if(p.ti.destination==2)
            bus3(p);
    }
    
    synchronized public void bus1(Passanger p)
    {
        try
        {
            bus1Seat.acquire(1);
            System.out.println("Passenger No. "+p.name+" boards bus 1 to north");
            Thread.sleep(1000);
            if(bus1Seat.availablePermits()==0)
            {
                System.out.println("Bus 1 has left the terminal");
                p.no.release(12);
                System.out.println("Passengers waiting ay area 1");
                Thread.sleep(10000);
                System.out.println("Bus 1 has arrived at the terminal");
                bus1Seat.release(12);
            }
        }
        catch(Exception e)
        {

        }
    }
    
    synchronized public void bus2(Passanger p)
    {
        try
        {
            bus2Seat.acquire(1);
            System.out.println("Passenger No. "+p.name+" boards bus 2 to east");
            Thread.sleep(1000);
            if(bus2Seat.availablePermits()==0)
            {
                System.out.println("Bus 2 has left the terminal");
                p.no.release(12);
                System.out.println("Passengers waiting ay area 2");
                Thread.sleep(10000);
                System.out.println("Bus 2 has arrived at the terminal");
                bus2Seat.release(12);
            }
        }
        catch(Exception e)
        {

        }
    }
    
    synchronized public void bus3(Passanger p)
    {
        try
        {
            bus3Seat.acquire(1);
            System.out.println("Passenger No. "+p.name+" boards bus 3 to west");
            Thread.sleep(1000);
            if(bus3Seat.availablePermits()==0)
            {
                System.out.println("Bus 3 has left the terminal");
                p.no.release(12);
                System.out.println("Passengers waiting ay area 3");
                Thread.sleep(10000);
                System.out.println("Bus 3 has arrived at the terminal");
                bus3Seat.release(12);
            }
        }
        catch(Exception e)
        {

        }
    }
}
