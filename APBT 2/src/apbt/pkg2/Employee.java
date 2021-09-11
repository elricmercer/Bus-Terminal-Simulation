package apbt.pkg2;

public class Employee extends Thread
{
    String title;
    int jobType, jobLocal;

    public Employee(String title, int jobType, int jobLocal)
    {
        this.title = title;
        this.jobType = jobType;
        this.jobLocal = jobLocal;
    }
}
