package apbt.pkg2;

public class TicketCounter
{
    Boarding b;
    
    synchronized public void ticketCounter_1(Passanger p)
    {
        String local = "";
        System.out.println(p.tt1.title+" is at Ticket Counter 01");
        try
        {
            Thread.sleep(100);
        }
        catch(Exception e)
        {
            
        }
        p.ticketBought = true;
        if(p.dest==0)
            local = "north";
        else if(p.dest==1)
            local = "east";
        else if(p.dest == 2)
            local = "west"; 
        System.out.println("Passanger: "+p.name+" bought a ticket to "+local);
        b.ticketScanner(p);
    }
    
    synchronized public void ticketCounter_2(Passanger p)
    {
        String local = "";
        System.out.println(p.tt2.title+" is at Ticket Counter 02");
        try
        {
            Thread.sleep(100);
        }
        catch(Exception e)
        {
            
        }
        p.ticketBought = true;
        if(p.dest==0)
            local = "north";
        else if(p.dest==1)
            local = "east";
        else if(p.dest == 2)
            local = "west"; 
        System.out.println("Passanger: "+p.name+" bought a ticket to "+local);
    }
    
    synchronized public void ticketMachine(Passanger p)
    {
        
    }
}
