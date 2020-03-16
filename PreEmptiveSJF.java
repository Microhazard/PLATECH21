import java.util.Scanner; 
public class PreEmptiveSJF {
    public static void main (String args[]) {
        int currentTime=0, total = 0;
        float averageWaitingTime=0, averageTurnAroundTime=0;
        Scanner input =new Scanner(System.in);

        //Input the Number of Process
        System.out.println ("Enter the Number of Process:");
        int numberOfProcess = input.nextInt();
        //Declare the sizes on each time based on number of process
        int process[] = new int[numberOfProcess];
        int arrivalTime[] = new int[numberOfProcess]; 
        int burstTime[] = new int[numberOfProcess]; 
        int completeTime[] = new int[numberOfProcess]; 
        int aroundTime[] = new int[numberOfProcess];
        int waitingTime[] = new int[numberOfProcess];
        boolean flag[] = new boolean[numberOfProcess];
        int totalBurstTime[]= new int[numberOfProcess];
 
        for (int i=0; i < numberOfProcess ; i++) {
            process[i]= i+1;
            System.out.println ("Enter process [" + (i+1) + "] for Arrival Time:");
            arrivalTime[i] = input.nextInt();
            System.out.println("Enter process [" + (i+1) + "] burst Time:");
            burstTime[i] = input.nextInt();
            totalBurstTime[i]= burstTime[i];
            flag[i] = false; //false
        }
        
        while(!false){
            int min=99,count = numberOfProcess;
            //if user enters a total process of 0
            if (total == numberOfProcess) {
                //break the loop
                break;
            }
            for (int i = 0;i < numberOfProcess; i++) {
                //get the min from the burstTime
                if ((arrivalTime[i]<=currentTime) && (flag[i]==false) && (burstTime[i] < min)) {    
                    min=burstTime[i];
                    count = i;
                }
            }
            //if count is equal to number of process
            if (count == numberOfProcess) {
                currentTime++;
            }
            else {
                //Burst Time based on index count will decrement
                burstTime[count]--;
                //current Time will increment
                currentTime++;
                if (burstTime[count] == 0) {
                    completeTime[count] = currentTime;
                    flag[count] = true;
                    total++;
                }
            }
        }
        
        for(int i = 0; i < numberOfProcess; i++) {
            //get the  around time from subtracting complete time and arrival time
            aroundTime[i] = completeTime[i] - arrivalTime[i];
            waitingTime[i] = aroundTime[i] - totalBurstTime[i];
            //getting the total waitingTime  and average waiting time NOTE: DILI SYA AVERAGE ADTO RA SA DISPLAY ANG AVERAGE
            averageWaitingTime+= waitingTime[i];
            averageTurnAroundTime += aroundTime[i];
        }
        
        System.out.println("Process \t Arrival Time \t Burst Time \t Waiting Time");
        for(int i=0;i<numberOfProcess;i++) {
            System.out.println(process[i] +" \t\t "+ arrivalTime[i]+" \t\t "+ totalBurstTime[i] +" \t\t "+ waitingTime[i]);
        }
        
        System.out.println("average tat is "+ (float)(averageTurnAroundTime/numberOfProcess));
        System.out.println("average waitingTIme is "+ (float)(averageWaitingTime/numberOfProcess));
    }
}