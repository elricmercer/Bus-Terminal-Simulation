package apbt;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Destination 
{
    MiniBus mb;
    WestEastEntrance wee;
    
    Lock l = new ReentrantLock();
    
    synchronized public void north(Passangers p)
    {
        if(wee.passangers<0)
            wee.passangers = 0;
        if(mb.available==true)
        {
            if(mb.busCap<=12)
            {
                System.out.println("Passanger: "+p.name+" has entered bus no."+mb.busNumber+" for north");
                mb.busCap++;
            }
            else
                mb.available = false;
        }
        else
        {
            System.out.println("Bus no. "+mb.busNumber+" to north is unavailable for now, please wait");
            l.lock();
            try
            {
                Thread.sleep(15000);
            }
            catch(Exception e)
            {
            
            }
            System.out.println("Bus no. "+mb.busNumber+" has arrived");
            l.unlock();
            mb.available = true;
            mb.busCap = 0;
            north(p);
        }
    }
    
    synchronized public void east(Passangers p)
    {
        if(wee.passangers<0)
            wee.passangers = 0;
        if(mb.available==true)
        {
            if(mb.busCap<=12)
            {
                System.out.println("Passanger: "+p.name+" has entered bus no."+mb.busNumber+" for east");
                mb.busCap++;
            }
            else
                mb.available = false;
        }
        else
        {
            System.out.println("Bus no. "+mb.busNumber+" to east is unavailable for now, please wait");
            l.lock();
            try
            {
                Thread.sleep(15000);
            }
            catch(Exception e)
            {
            
            }
            System.out.println("Bus no. "+mb.busNumber+" has arrived");
            l.unlock();
            mb.available = true;
            mb.busCap = 0;
            east(p);
        }
    }
    
    synchronized public void west(Passangers p)
    {
        if(wee.passangers<0)
            wee.passangers = 0;
        if(mb.available==true)
        {
            if(mb.busCap<=12)
            {
                System.out.println("Passanger: "+p.name+" has entered bus no."+mb.busNumber+" for west");
                mb.busCap++;
            }
            else
                mb.available = false;
        }
        else
        {
            System.out.println("Bus no. "+mb.busNumber+" to west is unavailable for now, please wait");
            l.lock();
            try
            {
                Thread.sleep(15000);
            }
            catch(Exception e)
            {
            
            }
            System.out.println("Bus no. "+mb.busNumber+" has arrived");
            l.unlock();
            mb.available = true;
            mb.busCap = 0;
            west(p);
        }
    }
    
    synchronized public void exit(Passangers p)
    {
        System.out.println("Passanger: "+p.name+" kicked out");
    }
}
