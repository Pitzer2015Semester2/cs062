public class Quick3 {

    private static boolean debug = true;
    private static boolean debug2 = true;

    public static void qsort(int[] a) {
        quickSort(a, 0, a.length - 1, 0);
    }

    private static void quickSort(int a[], int from, int to, int lev) {
        // Check the base case first
        // Your code for checking the base case goes here
        if(a.length==0){
            return;
        }
        // Determine the pivot element
        int[] three = {0, 0, 0};  // to get values from partition
        int p = partition(a, from, to, three);

        // This is useful for debugging
        // if (debug) printFromToPivot(from, to, p, lev);
        // if (debug2) printArrayIndent(a, ""+from+"-"+to+", p="+p+": ", lev);

        
        // int p = partition(a[a.length/2],from, to,a, three);
        quickSort(a, from, p-1,lev++);
        quickSort(a, p+1, to,lev++);
        // System.out.println("pivot = " + p);
        // printArray(a, "a: before partition is called ");
        // partition(p, from, to, a, three);
        // printArray(a, "a: after partition is called ");
        // printArray(three, "Three array: ");

        int nsp = three[0];  // # of elements smaller than p (see partition)
        int nep = three[1];  // # of elements equal to p
        int ngp = three[2];  // # of elements greater than p
        
        // // Find new from and to for two recursive calls
        int newFrom1  = 0;
        int  newFrom2  = 0;
        int  newTo1  = 0;
        int  newTo2 = 0;
        // newFrom1 = 
        int aLength = a.length;
        if((nsp==0)&&(ngp==0)){ // all same as pivot                |p|p|p|p|p|p|p|p|p|p|p|p| 


        } else if ((nsp==0)&&(ngp>0)){ // none smaller than pivot  |p| | | | | | | | | | | |
            newFrom2 = p++;
            newTo2 = aLength--;

        } else if ((nsp>0)&&(ngp==0)){// none greater than p      | | | | | | | | | | | |p|
            newFrom1 = 0;
            newTo1 = p--;

        } else{ // elements greater and less than p exist

        }
        // your code here to set these four variables before the recursive calls
        
        quickSort(a, newFrom1, newTo1, lev + 1);
        quickSort(a, newFrom2, newTo2, lev + 1);
    }
    

        public static void partition(int p, int from, int to,
                     int[] a, int[] three) {
            int nsp = 0;  // # of elements smaller than p seen so far
            int nep = 0;  // # of elements equal to p seen so far
            int ngp = 0;  // # of elements greater than p seen so far
            for (int i = from; i <= to; i++) {
                if (a[i] > p) {
                    ngp++;
                }
                else if (a[i] == p) {
                    nep++;
                    swap(a, i - ngp, i);
                }
                else if (a[i] < p) {
                    nsp++;
                    swap(a, i - ngp, i);
                    swap(a, i - (nep + ngp), i - ngp);
                }
            }
            three[0] = nsp;
            three[1] = nep;
            three[2] = ngp;
        }
        return nsp;

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
        /*
        // Partition test
        System.out.println();
        int[] M1 = {5, 6, 3, 5, 8, 7, 6, 5, 9, 2};
        int[] three = {0, 0, 0};
        partition(5, 2, 5, M1, three);
        printArray(three, "Three array: ");
        printArray(M1, "First: ");
        */

        // Quick sort tests
        int[] numbers1 = {14, 3, 2, 11, 10, 4, 8, 7, 6, 5, 9, 13, 12, 1};
        printArray(numbers1, "Before sorted: ");
        qsort(numbers1);
        printArray(numbers1, " After sorted: ");

        /*
        numbers1 = randomArray(20);
        printArray(numbers1, "Before sorted: ");
        qsort(numbers1);
        printArray(numbers1, " After sorted: ");
        */
        
        //        benchmark(100000, 1);
    }
}
