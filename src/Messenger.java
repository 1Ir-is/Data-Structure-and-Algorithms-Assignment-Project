public class Messenger {
    int bufferLimit = 150;
    int messageLimit = 250;

    String messageDestination= "";
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
        char[] source = messageSource.toCharArray();
        int n = 0;
        try
        {
            while(n < source.length && n < messageLimit)
            {
                while(myQueue.count() < bufferLimit && n < messageLimit)
                {
                    myQueue.enQueue(source[n]);
                    n++;

                    if (myQueue.isFull()){
                        afterUsedMem = (rt.totalMemory()-rt.freeMemory());
                    }
                }
//                measure
                if (afterUsedMem == 0){
                    afterUsedMem = (rt.totalMemory()-rt.freeMemory());
                }
                //when buffer full push
                while(myQueue.count()!=0){
                    messageDestination = messageDestination + myQueue.deQueue();
                }
            }
        }
        catch (Exception e){
            while(myQueue.count() != 0){
                messageDestination = messageDestination + myQueue.deQueue();
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
