package apbt.pkg3;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Destination 
{
    Entrance e;
    
    int bus_1Cap = 0,bus_2Cap = 0,bus_3Cap = 0;
    
    Lock l = new ReentrantLock();
    
    synchronized public void north(Passanger p)
    {
        try
        {
            Thread.sleep(500);
        }
        catch(Exception e)
        {
            
        }
        if(bus_1Cap<=12)
        {
            System.out.println("Passanger: "+p.name+" entered the bus to north");
            bus_1Cap++;
            e.passng--;
        }
        else
        {
            System.out.println("Bus to north is on its way, please wait");
            l.lock();
            try
            {
                Thread.sleep(15000);
            }
            catch(Exception e)
            {
                
            }
            l.unlock();
            bus_1Cap=0;
            north(p);
        }
    }
    
    synchronized public void east(Passanger p)
    {
        try
        {
            Thread.sleep(500);
        }
        catch(Exception e)
        {
            
        }
        if(bus_2Cap<=12)
        {
            System.out.println("Passanger: "+p.name+" entered the bus to east");
            bus_2Cap++;
            e.passng--;
        }
        else
        {
            System.out.println("Bus to east is on its way, please wait");
            l.lock();
            try
            {
                Thread.sleep(15000);
            }
            catch(Exception e)
            {
                
            }
            l.unlock();
            bus_2Cap=0;
            east(p);
        }
    }
    
    synchronized public void west(Passanger p)
    {
        try
        {
            Thread.sleep(500);
        }
        catch(Exception e)
        {
            
        }
        if(bus_3Cap<=12)
        {
            System.out.println("Passanger: "+p.name+" entered the bus to west");
            bus_3Cap++;
            e.passng--;
        }
        else
        {
            System.out.println("Bus to west is on its way, please wait");
            l.lock();
            try
            {
                Thread.sleep(15000);
            }
            catch(Exception e)
            {
                
            }
            l.unlock();
            bus_3Cap=0;
            west(p);
        }
    }
}
