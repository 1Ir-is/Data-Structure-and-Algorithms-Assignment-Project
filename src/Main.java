import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Messenger messenger = new Messenger();
        TimeExecution timeExecution = new TimeExecution();
        Scanner sc = new Scanner(System.in);
        System.out.print("(S1) Enter your message (Max: " + messenger.messageLimit + " characters): ");
        System.out.println();
        String sourceMessage = sc.nextLine();
        System.out.println();
        boolean key = true;
        while (key)
        {
            if (sourceMessage.length() == 0){
                System.out.println(" Your input is empty, please input again to send message!");
                System.out.print("(S1) Enter your message (Max: " + messenger.messageLimit + " characters): ");
                sourceMessage = sc.nextLine();
                System.out.println();
            }
            else key = false;
        }
        if (sourceMessage.length() <= messenger.messageLimit)
        {
            // Time the function
            timeExecution.Start();

            // Send message
            messenger.sendingMessage(sourceMessage);
            timeExecution.Stop();

            // Show message
            messenger.printMessage();

            // Show successfully sent message
            System.out.println("Successfully Sent " + messenger.S2.length() + " Characters!");
            System.out.println();

            // Show buffer size
            System.out.println("Buffer Size: " + messenger.bufferLimit);
            System.out.println();

            // Show time execution
            System.out.println("Executed time: " + timeExecution.Elapse() + " millisecond");
            System.out.println();

            // Show memory
            System.out.println("Memory Usage before send message: " + (messenger.beforeUsedMem) / 1024 + " KB");
            System.out.println();
            System.out.println("Memory Usage after send message: " + messenger.afterUsedMem / 1024 + " KB");
            System.out.println();
            System.out.println("Memory used: " + (messenger.afterUsedMem- messenger.beforeUsedMem)/1024 + " KB");
            System.out.println();
        }
        else
        {
            // Show error
            System.out.println("Your input too long, up to " + sourceMessage.length() + " characters, " +
                    "some part of message might not get send," +
                    " because we only send messages with a maximum of " + messenger.messageLimit + " characters.");
            System.out.println();

            // Time the function
            timeExecution.Start();
            
            // Send message
            messenger.sendingMessage(sourceMessage);
            timeExecution.Stop();
            
            // Show message
            messenger.printMessage();

            // Show successfully sent message
            System.out.println("Successfully Sent " + messenger.S2.length() + " Characters!");
            System.out.println();
            
            // Show buffer size
            System.out.println("Buffer Size: " + messenger.bufferLimit);
            System.out.println();

            // Show time execution
            System.out.println("Executed time: " + timeExecution.Elapse() + " millisecond");
            System.out.println();

            // Show memory
            System.out.println("Memory Usage before send message: " + (messenger.beforeUsedMem) / 1024 + " KB");
            System.out.println();
            System.out.println("Memory Usage after send message: " + messenger.afterUsedMem / 1024 + " KB");
            System.out.println();
            System.out.println("Memory used: " + (messenger.afterUsedMem- messenger.beforeUsedMem)/1024 + " KB");
            System.out.println();
        }

        //Show memory
//       System.out.println("Memory Usage before send message: " + messenger.);
//          System.out.println();
//        System.out.println("Memory Usage after send message: " + messenger.afterUsedMem);
//        System.out.println();
//        messenger.printMemoryUsage();

        System.out.println("----< Thank you for using GreMes >----");
        System.out.println("----< Press any key to exit >----");
    }
}



