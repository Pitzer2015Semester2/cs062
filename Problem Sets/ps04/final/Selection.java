// Collin blinder
//cblinder@students.pitzer.edu
import java.util.*;

public class Selection{

    public static void main(String[] args) {
        int[] a = {1, 4, 5, 2, 3, 7, 10, 9, 21, 3};
        sort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void sort(int[] a) {
        sSortRec(a, 0);		
    }	
    // Precondition: start a valid index into a.
    private static void sSortRec(int[] a, int start) {
        if (start < a.length) {

            // Find the index of the smallest element in a[start...a.length-1]
            int minIndex = indexOfSmallest(a, start); 

            // Move smallest element to start position
            swap(a, minIndex, start);

            // Recurse on everything to the left of start
            sSortRec(a, start+1);

        }
    }

    // Returns the index of the smallest element in a between the index start
    // and the end of the array inclusive.
    // Precondition: start is a valid index in a.
    private static int indexOfSmallest(int[] a, int start) {
        int minNum = a[start];
        int minIndex = start;
        for(int i=start; i<a.length; i++){
            if(a[i]<minNum){
                minNum = a[i];
                minIndex = i;
            }

        }
        return minIndex;
    }
    private static void swap(int[] a, int i, int j) {
        int temp = a[j];
        a[j] = a[i];
        a[i] = temp;
    }

    
}