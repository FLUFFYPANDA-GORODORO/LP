import java.util.Scanner;

public class RoundRobin {
    @SuppressWarnings({ "unused", "resource" })
    public static void main(String[] args){
        int i, j, k, q, n, sum = 0;
        Scanner st = new Scanner(System.in);

        System.out.println("Enter number of processes:");
        n = st.nextInt();

        int bt[] = new int[n];
        int wt[] = new int[n];
        int tat[] = new int[n];
        int a[] = new int[n];

        System.out.println("Enter burst times for each process:");
        for(i=0; i<n; i++){
            System.out.print("P["+i+"]: ");
            bt[i] = st.nextInt(); 
        }

        System.out.println("Enter Time Quantum:");
        q=st.nextInt();


        for (i = 0; i < n; i++) {
            a[i] = bt[i];
            wt[i] = 0;
        }
      
        do {
            for (i = 0; i < n; i++) {
                if (bt[i] > q) {
                    bt[i] -= q;
                    for (j = 0; j < n; j++) {
                        if ((j != i) && (bt[j] != 0)) {
                            wt[j] += q;
                        }
                    }
                } else if (bt[i] > 0) {
                    for (j = 0; j < n; j++) {
                        if ((j != i) && (bt[j] != 0)) {
                            wt[j] += bt[i];
                        }
                    }
                    bt[i] = 0;
                }
            }

            sum = 0;
            for (k = 0; k < n; k++) {
                sum += bt[k];
            }
        } while (sum != 0);

        for (i = 0; i < n; i++) {
            tat[i] = wt[i] + a[i];
        }


        System.out.println("Process\t\tBT\tWT\tTAT");
        for (i = 0; i < n; i++) {
            System.out.println("Process " + (i + 1) + "\t" + a[i] + "\t" + wt[i] + "\t" + tat[i]);
        }

        float avg_wt = 0;
        float avg_tat = 0;
        for (j = 0; j < n; j++) {
            avg_wt += wt[j];
        }
        for (j = 0; j < n; j++) {
            avg_tat += tat[j];
        }

        System.out.println("Average Waiting Time: " + (avg_wt / n));
        System.out.println("Average Turnaround Time: " + (avg_tat / n));

    }    
}
