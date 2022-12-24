public class TimeExecution {
    double start;
    double stop;

    public TimeExecution(){
        start = stop = 1;
    }

    public double Elapse(){
        return stop - start;
    }

    public void Start(){
        start = System.currentTimeMillis();
    }

    public void Stop(){
        stop = System.currentTimeMillis();
    }
}
