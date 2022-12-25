public class Messenger {
    int bufferLimit = 150;
    int messageLimit = 250;
    String S2= "";
    Runtime rt = Runtime.getRuntime();
//    long beforeUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
//    long afterUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
//    long actualMemUsed=afterUsedMem-beforeUsedMem;

    long beforeUsedMem;
    long afterUsedMem;
    public Messenger()
    {
    }
    public void sendingMessage(String messageSource){
        rt.gc();
        beforeUsedMem = rt.totalMemory() - rt.freeMemory();
        Queue myQueue = new Queue(bufferLimit);
        char[] S1 = messageSource.toCharArray();
        int n = 0;
        try
        {
            while(n < S1.length && n < messageLimit)
            {
                while(myQueue.count() < bufferLimit && n < messageLimit)
                {
                    myQueue.enQueue(S1[n]);
                    n++;

                    if (myQueue.isFull())
                    {
                        afterUsedMem = (rt.totalMemory() - rt.freeMemory());
                    }
                }
                //Measure
                if (afterUsedMem == 0)
                {
                    afterUsedMem = (rt.totalMemory() - rt.freeMemory());
                }
                //when buffer full push
                while(myQueue.count()!=0)
                {
                    S2 = S2 + myQueue.deQueue();
                }
            }
        }
        catch (Exception e){
            while(myQueue.count() != 0){
                S2 = S2 + myQueue.deQueue();
            }
        }
    }

    public void printMessage(){
        System.out.println("(S2) This is your message:");
        System.out.println(S2);
        System.out.println();
    }

//    public void printMemoryUsage(){
//        System.out.println("Amount of used memory: " + used_mem);
//    }
}
