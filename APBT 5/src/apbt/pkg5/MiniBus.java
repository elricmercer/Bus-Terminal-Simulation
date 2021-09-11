package apbt.pkg5;

import java.util.concurrent.Semaphore;

public class MiniBus extends Thread
{
    TheSimulation ts;
    
    public void run()
    {
         try
         {
             ts.wait(10000);
         }
         catch(Exception e)
         {
             
         }
         synchronized(this)
         {
             this.notify();
         }
    }
}
