import java.util.Scanner;

/**
 * Scheduling
 */
public class Scheduling {

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n, i, j, c = 0;

        System.out.println("Enter the no of Processes: ");
        n = sc.nextInt();
        
        int[] AT = new int[n];
        int[] BT = new int[n];
        int[] CT= new int[n];
        int[] TAT= new int[n];
        int[] WT= new int[n];
        
        System.out.println("Enter the Arrival time of the processes: ");
        for(i=0;i<n;i++){
            System.out.print("A" + i +": ");
            AT[i] = sc.nextInt();
            System.out.println();
        }

        System.out.println("Enter the Burst time of the processes: ");
        for(i=0;i<n;i++){
            System.out.print("B" + i +": ");
            BT[i] = sc.nextInt();
            System.out.println();
        }

        sc.close();

        //Completion Time
        for(j = 0; j< n;j++){
            c = c + BT[j];
            CT[j] = c; 
        }

        //Total Arrival Time
        for(i=0;i<n;i++){
            TAT[i] = CT[i] - AT[i];
        }

        //Wait Time
        for(i=0;i<n;i++){
            WT[i] = TAT[i] - BT[i];
        }
        

        System.out.println("Processes\tAT\t BT\t CT\t TAT\t WT");
        for(i = 0;i<n;i++){
        System.out.println("P" + i + "\t\t" + AT[i] +"\t  " +BT[i] +"\t  " +CT[i] +"\t  " +TAT[i] +"\t  " + WT[i]);
        }
        
        int sum = 0;
        float avgTAT = 0;
        float avgWT = 0;

        for(i=0;i<n;i++){
            sum = sum + TAT[i];
        }
        avgTAT = sum/n;
        System.out.println("Average TAT: " + avgTAT);
        sum = 0;
        for(i=0;i<n;i++){
            sum = sum + WT[i];
        }
        avgWT = sum/n;
        System.out.println("Average WT: " + avgWT);
    }
}
