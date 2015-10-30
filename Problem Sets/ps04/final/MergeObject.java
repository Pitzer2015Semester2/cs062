/* Merge sort is used in java.util.Arrays.sort to sort an array of
 * objects.  In this implementation, I chose to show the algorithm
 * that sorts an int array.  To sort an object array you would
 * have to incorporate the Comparable interface.  I will leave it
 * as an exercise.
 *
 * Also see MergeDebug.java for a version that contains some debugging
 * code that would help you understand the algorithm better.
 */

//Collin Blinder
//cblinder@students.pitzer.edu
public class MergeObject {
    public static void msort(Object[] a) {
        Object aux[] = a.clone();
        mergeSort(aux, a, 0, a.length);
    }

    private static void mergeSort(Object src[], Object dest[],
                                  int low, int high) {
        if ((high - low) < 2) {
            return;
        }
        int mid = (low + high) / 2;
        mergeSort(dest, src, low, mid);
        mergeSort(dest, src, mid, high);

        // typecasting arrays to refer to objects extending Comparable class   
        Comparable[] srcComparable = (Comparable[])src;
        Comparable[] destComparable = (Comparable[])dest;
        if (srcComparable[mid - 1].compareTo(srcComparable[mid])<0 || srcComparable[mid - 1].compareTo(srcComparable[mid])==0 ) {
            System.arraycopy(srcComparable, low, destComparable, low, high - low);
            return;
        }
        for (int i = low, p = low, q = mid; i < high; i++) {
            if ( (q>=high) || (p<mid && srcComparable[p].compareTo(srcComparable[q])<=0) ){ 
                destComparable[i] = srcComparable[p++];
            }
            else {
                destComparable[i] = srcComparable[q++];
            }
        }
    }
    private static void printArray(Object[] a, String msg) {
        System.out.println("\n\n" + msg);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+ " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        String strArr[] = {"C", "F", "D", "B", "A", "Q", "G"};
        //for testing
        printArray(strArr, "Before sorted:");
        msort(strArr);
        printArray(strArr, "After sorted:");
    }
}