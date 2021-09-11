package apbt.pkg3;

import java.util.Random;

public class Boarding 
{
    Destination d;
    Entrance e;
    
    synchronized public void checking(Passanger p)
    {
        String local="";
        System.out.println("Passanger: "+p.name+" scanned");
        if(p.buyTicket==true)
        {
            try
            {
                Thread.sleep(1000);
            }
            catch(Exception e)
            {

            }
            int ran = new Random().nextInt(6);
            if(p.dest==0)
                local = "north";
            else if(p.dest==1)
                local = "east";
            else if(p.dest==2)
                local = "west";
            System.out.println("Inspector checking passanger "+p.name+" ticket for destination "+local);
            if(p.checkTicket==false)
            {
                try
                {
                    Thread.sleep(1000);
                }
                catch(Exception e)
                {

                }
                p.checkTicket = true;
                System.out.println("Inspector approved of passanger "+p.name+"'s ticket");
                switch(p.dest)
                {
                    case 0: d.north(p);
                    break;
                    case 1: d.east(p);
                    break;
                    case 2: d.west(p);
                    break;
                    default: System.out.println("ERROR....!");
                }
            }
            else
            {
                System.out.println("Inspector disapproved of passanger"+p.name+"'s ticket ");
                e.passng--;
            }
        }
    }
}
