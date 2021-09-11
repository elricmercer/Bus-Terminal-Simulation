package apbt.pkg3;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TicketCounter
{
    Boarding b;
    
    Lock l = new ReentrantLock();
    
    synchronized public void ticketCounter_1(Passanger p)
    {
        l.lock();
        String local="";
        int ran = new Random().nextInt(100);
        if(ran%10==0)
        {
            System.out.println("Ticket Personnal at counter 1 is not available, please wait");
            try
            {
                Thread.sleep(2000);
            }
            catch(Exception e)
            {
                
            }
            System.out.println("Ticket personnel at counter 1 has arrived");
            p.buyTicket = true;
            if(p.dest==0)
                local = "north";
            else if(p.dest==1)
                local = "east";
            else if(p.dest==2)
                local = "west";
            System.out.println("Passanger: "+p.name+" bought a ticket to destination "+local);
            l.unlock();
            b.checking(p);
        }
        else
        {
            System.out.println("Ticket Personnal is at ticket counter 1");
            try
            {
                Thread.sleep(500);
            }
            catch(Exception e)
            {

            }
            p.buyTicket = true;
            if(p.dest==0)
                local = "north";
            else if(p.dest==1)
                local = "east";
            else if(p.dest==2)
                local = "west";
            System.out.println("Passanger: "+p.name+" bought a ticket to destination "+local);
            l.unlock();
            b.checking(p);
        }
    }
    
    synchronized public void ticketCounter_2(Passanger p)
    {
        l.lock();
        String local="";
        int ran = new Random().nextInt(100);
        if(ran%10==0)
        {
            System.out.println("Ticket Personnal at counter 2 is not available, please wait");
            try
            {
                Thread.sleep(2000);
            }
            catch(Exception e)
            {
                
            }
            System.out.println("Ticket personnel at counter 2 has arrived");
            p.buyTicket = true;
            if(p.dest==0)
                local = "north";
            else if(p.dest==1)
                local = "east";
            else if(p.dest==2)
                local = "west";
            System.out.println("Passanger: "+p.name+" bought a ticket to destination "+local);
            l.unlock();
            b.checking(p);
        }
        else
        {
            System.out.println("Ticket Personnal is at ticket counter 2");
            try
            {
                Thread.sleep(500);
            }
            catch(Exception e)
            {

            }
            p.buyTicket = true;
            if(p.dest==0)
                local = "north";
            else if(p.dest==1)
                local = "east";
            else if(p.dest==2)
                local = "west";
            System.out.println("Passanger: "+p.name+" bought a ticket to destination "+local);
            l.unlock();
            b.checking(p);
        }
    }
    
    synchronized public void ticketMachine(Passanger p)
    {
        l.lock();
        String local="";
        int ran = new Random().nextInt(100);
        if(ran%4==0)
        {
            try
            {
                Thread.sleep(500);
            }
            catch(Exception e)
            {
                
            }
            System.out.println("The Ticket Machine is out of order, please move to the other counter");
            ran = new Random().nextInt(2);
            switch(ran)
            {
                case 0: 
                {
                    l.unlock();
                    ticketCounter_1(p);
                }
                break;
                case 1: 
                {
                    l.unlock();
                    ticketCounter_2(p);
                }
                break;
                default: System.out.println("ERROR....!");
            }
        }
        else
        {
            try
            {
                Thread.sleep(500);
            }
            catch(Exception e)
            {
                
            }
            p.buyTicket = true;
            if(p.dest==0)
                local = "north";
            else if(p.dest==1)
                local = "east";
            else if(p.dest==2)
                local = "west";
            System.out.println("Passanger: "+p.name+" bought ticket from ticket machine to destination "+local);
            l.unlock();
            b.checking(p);
        }
    }
}
