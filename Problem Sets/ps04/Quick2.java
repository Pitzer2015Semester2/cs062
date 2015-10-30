public class Quick2 {

    private static boolean debug = true;
    private static boolean debug2 = true;

    public static void qsort(int[] a) {
        quickSort(a, 0, a.length - 1, 0);
    }

    private static void quickSort(int a[], int from, int to, int lev) {
        // Check the base case first
        // Your code for checking the base case goes here
        if(to-from>2){
            
        
            // Determine the pivot element
            int[] three = {0, 0, 0}; 
            int p = partition(a[from], from, to, a, three);

            // This is useful for debugging
            // if (debug) printFromToPivot(from, to, p, lev);
            // if (debug2) printArrayIndent(a, ""+from+"-"+to+", p="+p+": ", lev);

            // to get values from partition

            System.out.println("pivot = " + a[p]);
            // printArray(a, "a: before partition is called ");
            partition(p, from, to, a, three);
            // printArray(a, "a: after partition is called ");
            // printArray(three, "Three array: ");

            int nsp = three[0];  // # of elements smaller than p (see partition)
            int nep = three[1];  // # of elements equal to p
            int ngp = three[2];  // # of elements greater than p
            
            // Find new from and to for two recursive calls
            int newFrom1, newFrom2, newTo1, newTo2;

            if((nsp==0)&&(ngp==0)){ // all same as pivot                |p|p|p|p|p|p|p|p|p|p|p|p| 
                return;

            } else if ((nsp==0)&&(ngp>0)){ // none smaller than pivot  |p| | | | | | | | | | | |
                newFrom2 = p+1;
                newTo2 = to;
                newFrom1 = 0;
                newTo1 = 0;


            } else if ((nsp>0)&&(ngp==0)){// none greater than p      | | | | | | | | | | | |p|
                newFrom1 = from;
                newTo1 = p-1;
                newFrom2 = 0;
                newTo2 = 0;

            } else{ // elements greater and less than p exist
                newFrom1 = from;
                newTo1 = p-1;
                newFrom2 = p+1;
                newTo2 = to;

            }
            // your code here to set these four variables before the recursive calls
            
            quickSort(a, newFrom1, newTo1, lev + 1);
            quickSort(a, newFrom2, newTo2, lev + 1);
        }
    }
    

    public static int partition(int p, int from, int to,
                                 int[] a, int[] three) {
            int counter =0;
            int arrLen = a.length-1;
            int retVal = 0;
            

            for(int i=0; i<a.length; i++){
                if(a[i]<p){
                    three[0]++;
                    swap(a,counter,i);
                    counter++;  
                }   
            }
            for(int j=a.length-1; j>=0; j--){
                if(a[j]>p){
                    three[2]++;
                    swap(a,arrLen,j); 
                    arrLen--;   
                }
            }

            for(int i = 0; i<a.length; i++){
                if(a[i] == p){
                    retVal = i;
                }
            }
            three[1] = (a.length)-(three[0]+three[2]);
            return retVal;
    }
    
    
    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    
    private static void printFromToPivot(int from, int to, int p, int lev) {
        for (int i = 0; i < lev; i++) {
            System.out.print("    ");
        }
        System.out.println(from + "--" + to + " p " + p);
    }

    private static void printArray(int[] a, String msg) {
        System.out.print("\n" + msg);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    private static void printArrayIndent(int[] a, String msg, int lev) {
        for (int i = 0; i < lev; i++) {
            System.out.print("   ");
        }
        System.out.print(msg);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println("\n\n");
    }

    // Returns an array of n random integers.  The integers are
    // chosen from the interval [0..n)
    public static int[] randomArray (int n) {
        int[] A;
        A = new int[n];
        java.util.Random r = new java.util.Random();
        for (int i = 0; i < n; i++) {
            A[i] = r.nextInt(n * 10);
        }
        return A;
    }


    public static void benchmark(int size, int repts) {
        long sumTime = 0;
        System.out.println();
        for (int i = 0; i < repts; i++) {
            int[] a = randomArray(size);
            //            printArray(a, "Before sorted: ");
            System.out.println("Quick sort run number " + (i+1) + " started (size: " + size + ")");
            long start = System.currentTimeMillis();
            qsort(a);
            long timeTaken = (System.currentTimeMillis() - start);
            sumTime = sumTime + timeTaken;
            //            printArray(a, "  After sorted: ");
        }
        System.out.println("Quick sort took " + (sumTime/(long)repts) + " milliseconds.");
    }


    public static void main (String[] args) {
        
        // Partition test
        // System.out.println("-----------------------------");
        // int[] M1 = {7, 6, 3, 5, 8, 5, 6, 5, 9, 2};
        // int[] three = {0, 0, 0};
        // printArray(M1,"First: "); 
        // System.out.println("-----------------------------");
        // System.out.println("partition: " +M1[0] + " from: " +M1[0] +" to: "+M1[M1.length-1]);

        // partition(M1[0], 0, M1.length-1, M1, three);
        
        // printArray(M1, "L1: ");
        // printArray(three, "Three array: ");

        // System.out.println("-----------------------------");
        // three[0]=0;
        // three[1]=0;
        // three[2]=0;  
        //         System.out.println("partition: " +M1[6] + " from: " +M1[0] +" to: "+M1[6]);
 
        // // partition(M1[6], 0, 6, M1, three);
       
        // // printArray(M1, "L2A: ");
        // //  printArray(three, "Three array: ");

        // // System.out.println("-----------------------------");
        // // three[0]=0;
        // // three[1]=0;
        // // three[2]=0;  
        // //         System.out.println("partition: " +M1[9] + " from: " +M1[8] +" to: "+M1[M1.length-1]);
 
        // // partition(M1[9], 8, M1.length-1, M1, three);

        
        // // printArray(M1, "L2B: ");
        // // printArray(three, "Three array: ");

        // // System.out.println("-----------------------------");
        // //         three[0]=0;
        // // three[1]=0;
        // // three[2]=0;
        // // System.out.println("partition: " +M1[6] + " from: " +M1[1] +" to: "+M1[6]);   
        // // partition(M1[6], 1, 6, M1, three);

       
        // // printArray(M1, "First: ");
        // //  printArray(three, "Three array: ");
        

        // Quick sort tests
        int[] numbers1 = {14, 3, 2, 11, 10, 4, 8, 7, 6, 5, 9, 13, 12, 1};
        printArray(numbers1, "Before sorted: ");
        qsort(numbers1);
        printArray(numbers1, " After sorted: ");

        
        numbers1 = randomArray(20);
        printArray(numbers1, "Before sorted: ");
        qsort(numbers1);
        printArray(numbers1, " After sorted: ");
        
        
        //        benchmark(100000, 1);
    }
}
