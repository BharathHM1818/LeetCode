
class Signal
{
    public  synchronized void show(String light, int duration, String action)
    {
       try
       {
            System.out.println(light + " Signal is ON: " + action);
            Thread.sleep(duration);
            System.out.println(light + " Signal is OFF..");
            Thread.sleep(duration);
       }
       catch(Exception e)
       {
        e.printStackTrace();
       }
    }
}

class Red extends Thread
{
    Signal signal;

    public Red(Signal s)
    {
        this.signal = s;
    }

    @Override
    public void run()
    {
        signal.show("red", 500, "STOP");
    }
}

class Green extends Thread
{

    Signal signal;

    public Green(Signal s)
    {
        this.signal = s;
    }

    @Override
    public void run()
    {
        signal.show("Green", 500, "You gooooo");
    }
}

class Yellow extends Thread
{
    Signal signal;

    public Yellow(Signal s)
    {
        this.signal = s;
    }

    @Override
    public void run()
    {
        signal.show("Yellow", 500, "Start the Engine");
    }
}


class TrafficMain
{
    public static void main(String[] args) 
    {
        Signal s = new Signal();
        Red r  = new Red(s);
        Green g = new Green(s);
        Yellow y = new Yellow(s);

        r.start();
        g.start();
        y.start();
        System.out.println("Traffic Cycle complete...");
    }
}
