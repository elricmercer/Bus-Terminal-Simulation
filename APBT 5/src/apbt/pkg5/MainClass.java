package apbt.pkg5;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class MainClass
{
    public static void main(String[] args) 
    {
        Semaphore passNo = new Semaphore(70);
        TheSimulation ts = new TheSimulation();
        TicketData td = new TicketData(false,0,0);
        MiniBus mb = new MiniBus();
        Passanger p[] = new Passanger[30];
        for(int i=0;i<p.length;i++)
        {
            int gate = new Random().nextInt(2);
            int ticket = new Random().nextInt(3);
            p[i] = new Passanger(Integer.toString(i+1),gate,ticket,passNo,td,ts);
        }
        for(int i=0;i<p.length;i++)
        {
            p[i].start();
        }
        for(int i=0;i<p.length;i++)
        {
            try
            {
                p[i].join();
            }
            catch(Exception e)
            {
                
            }
        }
        System.out.println("**********************THE END***************************");
    }
}
