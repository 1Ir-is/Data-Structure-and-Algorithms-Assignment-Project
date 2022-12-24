public class Messenger {
    int bufferLimit = 500;
    int messageLimit = 10000;

    String messageDestination= "";
//    long beforeUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
//    long afterUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
//    long actualMemUsed=afterUsedMem-beforeUsedMem;
//    Runtime rt = Runtime.getRuntime();
//    long total_mem = rt.totalMemory();
//    long free_mem = rt.freeMemory();
//    long used_mem = total_mem - free_mem;
    long memoryUsedBefore;
    long memoryUsedAfter;
    public Messenger()
    {
    }

    public void sendingMessage(String messageSource){
        Runtime rt = Runtime.getRuntime();
        rt.gc();
        memoryUsedBefore = (rt.totalMemory()-rt.freeMemory()/1024);
        Queue myQueue = new Queue(bufferLimit);
        char[] source = messageSource.toCharArray();
        memoryUsedAfter = (rt.totalMemory()-rt.freeMemory()/1024);
        int n = 0;
        try
        {
            while(n < source.length && n < messageLimit)
            {
                while(myQueue.count() < bufferLimit && n < messageLimit)
                {

                    myQueue.enQueue(source[n]);
                    n++;
                }
                //When buffer is full!
                while(myQueue.count() != 0){
                    messageDestination += String.valueOf(myQueue.deQueue());
                }
            }
        }
        catch (Exception e){
            while(myQueue.count() != 0){
                messageDestination += String.valueOf(myQueue.deQueue());
            }
        }
    }

    public void printMessage(){
        System.out.println("This is your message in " + messageLimit + " characters :");
        System.out.println(messageDestination);
        System.out.println();
    }

//    public void printMemoryUsage(){
//        System.out.println("Amount of used memory: " + used_mem);
//    }
}
