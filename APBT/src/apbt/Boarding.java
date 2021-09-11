package apbt;

public class Boarding 
{
    Destination d;
    
    synchronized public void ticketScanner(Passangers p, Employee em)
    {
        String emp="";
        if(p.buyTicket==true)
        {
            System.out.println("Passanger: "+p.name+" ticket Scanned");
            try
            {
                Thread.sleep(2000);
            }
            catch(Exception e)
            {
                
            }
            if(em.type==1)
                emp = "Inspector";
            if(p.checkTicket==false)
            {
                System.out.println(emp+" "+em.name+": Passanger - "+ p.name+" ticket checked");
                p.checkTicket=true;
                switch(p.dest)
                {
                    case 1: d.north(p);
                    break;
                    case 2: d.east(p);
                    break;
                    case 3: d.west(p);
                    break;
                    default: System.out.println("ERROR....!");
                }
            }
            else
            {
                System.out.println("INVALID TICKET");
                d.exit(p);
            }
        }
    }
}
