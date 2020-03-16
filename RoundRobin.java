import java.util.Scanner;
public class RoundRobin {
    public static void main(String[] Args) {
        Scanner input = new Scanner(System.in);
        int totalProcess,time = 0,remain, quantum; 
        boolean flag = false;
        int waitingTime=0,turnAroundTime=0;
        int[] arrivalTime,burstTime,remainingTime; 
        System.out.println("Enter Total Process: "); 
        totalProcess = input.nextInt();
        System.out.println("Enter the Quantum time: ");
        quantum = input.nextInt();
        remain=totalProcess; 
        arrivalTime = new int[totalProcess];
        burstTime = new int[totalProcess];
        remainingTime = new int[totalProcess]; 
        for(int x=0; x < totalProcess;x++) 
        { 
            System.out.println("Enter the Burst Time for Process Process Number " + (x+1) +": "); 
            burstTime[x] = input.nextInt();
            arrivalTime[x] = x;
            remainingTime[x]=burstTime[x]; 
        } 
        System.out.println("Process \t Waiting Time"); 
        for(int x =0, y=0;remain!=0;) 
        {
            if(remainingTime[y] <=quantum && remainingTime[y]>0) 
            { 
                time += remainingTime[y]; 
                remainingTime[y]=0; 
                flag = true; 
            } 
            else if(remainingTime[y]>0) 
            { 
                remainingTime[y] -= quantum; 
                time+=quantum; 
            } 
            if(remainingTime[y] == 0 && flag == true) 
            { 
                remain--; 
                System.out.println("P" + (y+1) + "\t\t" + (time-arrivalTime[y]-burstTime[y])); 
                waitingTime += time-arrivalTime[y]-burstTime[y]; 
                turnAroundTime += time-arrivalTime[y]; 
                flag=false; 
            } 
            if(y==totalProcess-1) 
                y=0; 
            else if(arrivalTime[y+1]<=time) 
                y++; 
            else 
                y=0; 
        } 
        System.out.println("\nAverage Waiting Time: "+ waitingTime/totalProcess); 
        System.out.println("Avg Turnaround Time: "+ turnAroundTime/totalProcess); 
    }
}
