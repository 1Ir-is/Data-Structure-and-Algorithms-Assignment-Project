import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Messenger messenger = new Messenger();
        TimeExecution timeExecution = new TimeExecution();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your message (Max: " + messenger.messageLimit + " characters): ");
        System.out.println();
        String source = sc.nextLine();
        System.out.println();

        boolean key = true;
        while (key)
        {
            if (source.length()==0){
                System.out.println("Your input is empty, please input again to send message!");
                System.out.print("Enter your message (Max: " + messenger.messageLimit + " characters): ");
                source = sc.nextLine();
                System.out.println();
            }
            else key = false;
        }
        if (source.length()<= messenger.messageLimit)
        {
            //time the function
            timeExecution.Start();
            messenger.sendingMessage(source);
            timeExecution.Stop();


            messenger.printMessage();
            System.out.println("Successfully Transferred " + messenger.messageDestination.length() + " Characters!");
            System.out.println();
            System.out.println("Buffer Size: " + messenger.bufferLimit);
            System.out.println();
            System.out.println("Executed time: " + timeExecution.Elapse() + " millisecond");
        }
        else
        {
            System.out.println("Your input too long, up to " + source.length() + " characters, " +
                    "please resend, we only send messages with a maximum of " + messenger.messageLimit + " characters");
            System.out.println();
            //time the function
            timeExecution.Start();
            messenger.sendingMessage(source);
            timeExecution.Stop();


            messenger.printMessage();
            System.out.println("Successfully Transferred " + messenger.messageDestination.length() + " Characters!");
            System.out.println();
            System.out.println("Buffer Size: " + messenger.bufferLimit);
            System.out.println();
            System.out.println("Executed time: " + timeExecution.Elapse() + " millisecond");
        }

        //Show memory
//       System.out.println("Memory Usage before send message: " + messenger.);
//          System.out.println();
//        System.out.println("Memory Usage after send message: " + messenger.afterUsedMem);
//        System.out.println();
//        messenger.printMemoryUsage();
        System.out.printf("Memory used: %s B",messenger.memoryUsedAfter-messenger.memoryUsedBefore);
        System.out.println("----< Thank you to using GreMes >----");
        System.out.println("----< Press any key to exit >----");
    }
}



