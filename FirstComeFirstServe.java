import java.util.Scanner;
public class FirstComeFirstServe {
    public static void main(String[] Args) {
        Scanner input = new Scanner(System.in);
        int[] process;
        int[] burstTime;
        int[] waitingTime;
        int totalWaitingTime = 0;
        int totalProcess;
        int temp = 0;
        double averageWaitingTime;
        
        System.out.println("Enter how many processes: ");
        totalProcess = input.nextInt();
        
        process = new int[totalProcess];
        burstTime = new int[totalProcess];
        waitingTime = new int[totalProcess];
        for(int x = 0; x < totalProcess; x++) {
            System.out.println("Enter the burstime for process "+(x+1)+": ");
            burstTime[x] = input.nextInt();
            process[x] = x + 1;
        }        
        //Begin to calulate the wating time from the burst time.
        waitingTime[0] = 0;
        for(int x = 0; x < totalProcess-1; x++) {
            waitingTime[x+1] = burstTime[x] + temp;
            temp = waitingTime[x+1];
        }
        //calculate the waiting time
        for(int x = 0; x < totalProcess-1; x++) {
            totalWaitingTime += waitingTime[x+1];
        }
        //Display
        System.out.println("Process \tBurst Time \tWaiting Time");         
        for(int x = 0; x < totalProcess; x++) {
            System.out.println(process[x] + "\t\t" + burstTime[x] + "\t\t" + waitingTime[x]); 
        }   
        System.out.println("Total waiting time: " + totalWaitingTime + " ms");     
        averageWaitingTime = totalWaitingTime / totalProcess;
        System.out.println("Total waiting time: " + (averageWaitingTime));
    }
}
