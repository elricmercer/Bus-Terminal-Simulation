package apbt;

public class Employee extends Thread
{
    String name;
    int type;
    int job;
    
    Boarding b;
    Passangers p;

    public Employee(String name, int type, int job) 
    {
        this.name = name;
        this.type = type;
        this.job = job;
    }
    
    public void run()
    {
        if(type==1)
        {
            b.ticketScanner(p, this);
        }
        else if(type==2)
        {
            if(job==1)
            {
                
            }
        }
    }
}
