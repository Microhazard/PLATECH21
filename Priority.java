import java.util.Scanner;
public class Priority{
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int temp, averageWaitingTime, averageTurnAroundTime, numberOfProcess;
    
        System.out.print("Enter the number of process : ");
        numberOfProcess = input.nextInt();
        
        int[] process = new int[numberOfProcess];
        int[] priority = new int[numberOfProcess];
        int[] burstTime = new int[numberOfProcess];
        int[] waitTime = new int[numberOfProcess];
        int[] turnAroundTime = new int[numberOfProcess];

        System.out.println("\t Enter the burst time and time priorities \n");
    
        for(int i = 0; i < numberOfProcess; i++) {
            System.out.println("Process["+(i+1)+"]:");
            System.out.println("    Enter the burst time:");
            burstTime[i] = input.nextInt();
            System.out.println("    Enter the time priorities:");
            priority[i] = input.nextInt();
            process[i]=i+1;
        }
    
        //sorting on the basis of priority
        for(int x = 0; x < numberOfProcess - 1; x++) {
            for(int y = x + 1; y < numberOfProcess; y++) {
                if(priority[x]>priority[y]) {
                    //Swap priorities
                    temp=priority[x];
                    priority[x] = priority[y];
                    priority[y] = temp;
                    //Swap burst time
                    temp = burstTime[x];
                    burstTime[x] = burstTime[y];
                    burstTime[y] = temp;
                    //swap process
                    temp=process[x];
                    process[x] = process[y];
                    process[y] = temp;
                }
            }
        }
        //Assign waiting time index 0 to 0
        waitTime[0] = 0;
        //Assign average waiting time to 0        
        averageWaitingTime = 0;
        turnAroundTime[0] = burstTime[0];
        averageTurnAroundTime = turnAroundTime[0];
        //calculate the average turn around time and average waiting time 
        for(int x = 1; x < numberOfProcess; x++) {
            waitTime[x] = turnAroundTime[x-1];
            averageWaitingTime += waitTime[x];
            turnAroundTime[x] = waitTime[x] + burstTime[x];
            averageTurnAroundTime += turnAroundTime[x];
        }
        //use the display method
        display(process, burstTime, waitTime, turnAroundTime, priority, averageWaitingTime, averageTurnAroundTime, numberOfProcess);
    }
    public static void display(int[] process, int[] burstTime, int[] waitTime, int[] turnAroundTime, int[] priority, int averageWaitingTime, int averageTurnAroundTime, int numberOfProcess) {
        System.out.println("Process \t Burst Time \t Wait Time \t Turn Around Time  Priority");
        System.out.println("====================================================================================================");
        for(int i = 0; i < numberOfProcess; i++) {
            System.out.println(process[i] + "\t\t   " + burstTime[i] + "\t\t     "+ waitTime[i] + "\t\t     " + turnAroundTime[i] + "\t\t     "+ priority[i] + "\n");
        }
        averageWaitingTime/=numberOfProcess;
        averageTurnAroundTime/=numberOfProcess;
        System.out.println("Average Wait Time : " + averageWaitingTime);
        System.out.println("Average Turn Around Time : " + averageTurnAroundTime);            
    } 
}