package apbt;

public class Passangers extends Thread
{
    String name;
    int dest,gCh,tCh;
    boolean buyTicket, checkTicket;
    WestEastEntrance wee;

    public Passangers(String name, int dest, int gCh, int tCh, boolean buyTicket, boolean checkTicket)
    {
        this.name = name;
        this.dest = dest;
        this.gCh = gCh;
        this.tCh = tCh;
        this.buyTicket = buyTicket;
        this.checkTicket = checkTicket;
    }
    
    public void run()
    {
        switch(gCh)
        {
            case 0: wee.westEntrance(this);
            break;
            case 1: wee.eastEntrance(this);
            break;
            default: System.out.println("ERROR...!");
        }
    }   
}
