package apbt.pkg6;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TerminalSimulation
{
    boolean broken = true;
    boolean toilet1 = true, toilet2 = true;
    int que=0;
    
    Semaphore bus1Seat = new Semaphore(12);
    Semaphore bus2Seat = new Semaphore(12);
    Semaphore bus3Seat = new Semaphore(12);
    Semaphore qQ = new Semaphore(5);
    
    //To queue passangers before buying the ticket
    public void qQQQ(Passanger p)
    {
        p.q.lock();
        try
        {
            if(qQ.availablePermits()==0)
            {
                System.out.println("Ticket counter queue is full, please wait");
                Thread.sleep(5000);
                qQ.release(5);
            }
            qQ.acquire(1);
            System.out.println("Passenger No. "+p.name+" in queue for ticket");
            p.q.unlock();
            ticket(p);
        }
        catch(Exception e)
        {
            
        }
    }
    
    public void ticket(Passanger p)
    {
        //This is to prevent a deadlock where ticket counter 1 & 2 and the ticket machine is unavaialble
        p.tk.lock();
        if(toilet1==true&&toilet2==true&&broken==true)
        {
            int num = new Random().nextInt(2);
            if(num==0)
            {
                int turnOn = new Random().nextInt(3);
                if(turnOn==0)
                    toilet1=false;
                else if(turnOn==1)
                    toilet2 = false;
                else if(turnOn==2)
                    broken = false;
            }
            else if(num==1)
            {
                for(int i=0;i<2;i++)
                {
                    int turnOn = new Random().nextInt(3);
                    if(turnOn==0)
                        toilet1=false;
                    else if(turnOn==1)
                        toilet2 = false;
                    else if(turnOn==2)
                        broken = false; 
                }
            }
        }
        
        //Ticket counter 1
        if(p.ticketCh==0)
        {
            try
            {
                Thread.sleep(3000);
            }
            catch(Exception e)
            {
                
            }
            if(toilet1)
            {
                System.out.println("Ticket Counter 1 Personnel is on break, please try the other counters");
                int ran = new Random().nextInt(2);
                if(ran==0)
                {
                    p.ticketCh=1;
                    p.tk.unlock();
                    ticket(p);
                }
                else
                {
                    p.ticketCh=2;
                    p.tk.unlock();
                    ticket(p);
                }
            }
            else
            {
                System.out.println("Passenger No. "+p.name+" bought ticket from counter 1");
                p.ti.status = true;
                int dest = new Random().nextInt(3);
                p.ti.destination=dest;
                p.ti.busNo=dest;
                p.tk.unlock();
                Inspector(p);
            }
        }
        
        //Ticket counter 2
        else if(p.ticketCh==1)
        {
            try
            {
                Thread.sleep(3000);
            }
            catch(Exception e)
            {
                
            }
            if(toilet2)
            {
                System.out.println("Ticket Counter 2 Personnel is on break, please try the other counters");
                int ran = new Random().nextInt(2);
                if(ran==0)
                {
                    p.ticketCh=0;
                    p.tk.unlock();
                    ticket(p);
                }
                else
                {
                    p.ticketCh=2;
                    p.tk.unlock();
                    ticket(p);
                }
            }
            else
            {
                System.out.println("Passenger No. "+p.name+" bought ticket from counter 2");
                p.ti.status = true;
                int dest = new Random().nextInt(3);
                p.ti.destination=dest;
                p.ti.busNo=dest;
                p.tk.unlock();
                Inspector(p);
            }
        }
        
        //Ticket machine
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
                p.tk.unlock();
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
                p.tk.unlock();
                Inspector(p);
            }
        }
    }
    
    //Checks passanger's ticket status
    public void Inspector(Passanger p)
    {
        p.ins.lock();
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
                p.ins.unlock();
                Departure(p);
            }
    }
    
    //Based on the desniation in the ticket, the passanger moves to their respective buses
    synchronized public void Departure(Passanger p)
    {
        if(p.ti.destination==0)
            bus1(p);
        else if(p.ti.destination==1)
            bus2(p);
        else if(p.ti.destination==2)
            bus3(p);
    }
    
    //Max of 12 passangers can board, after that bus leaves and the rest needs to wait
    public void bus1(Passanger p)
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
    
    public void bus2(Passanger p)
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
    
    public void bus3(Passanger p)
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
