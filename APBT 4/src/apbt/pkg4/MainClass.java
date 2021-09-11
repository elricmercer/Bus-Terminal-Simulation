package apbt.pkg4;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class MainClass 
{
    public static void main(String[] args) 
    {
        Semaphore passNum = new Semaphore(70);
        TerminalSimulation t = new TerminalSimulation();
        TicketInfo tf = new TicketInfo(false,0,0);
        Passanger p[] = new Passanger[40];
        for(int i=0;i<p.length;i++)
        {
            int gate = new Random().nextInt(2);
            int ticket = new Random().nextInt(3);
            p[i] = new Passanger(Integer.toString(i+1),gate,ticket,passNum,tf,t);
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
        System.out.println();
        System.out.println("**********************THE END***************************");
    }
}


/////use this simulation