/**
 * External merge sort: sorting a file containing integers, one per line.
 * Art Lee for CS 62
 * 10/3/2015
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;


public class ExternalMergeSort {

    private static int N = 100; // Number of items in the file to be sorted.
    private static int sliceSize = 20;  // Max number of items the memory buffer can hold.

    // Sorts the n items in inFile and stores the sorted result to
    // a file named inFile + o in the same folder, e.g., if inFile is
    // input.txt11, then the new file will be named input.txt11o.
    private static String[] sortFile(int n, String inFile) {
        // System.out.println("in sortFile");
        try {
            FileReader fr = new FileReader(inFile);
            BufferedReader br = new BufferedReader(fr);
            // int[] buffer = new int[n]; //Need to work on this
            String[] buffer = new String[n];

            // Read in the integers from inFile into buffer.
            // fr.read(buffer);
            
            for (int i = 0; i < n; i++) {
                buffer[i] = br.readLine();
            }
            // System.out.println("buffer: ");
            // for (int i = 0; i < n; i++) {
            //     System.out.println(buffer[i]);
            // }

            // Sort buffer using Quick Sort that you will implement.
            Quick.qsort(buffer, 0, n, 0)

            for (int i = 0; i < n; i++) {
                System.out.println(buffer[i]);
            }
            
            // Write the sorted numbers to temp file name ending with an "o"
            FileWriter fw = new FileWriter(inFile + "o");
            PrintWriter pw = new PrintWriter(fw);
            // Fill_it_in
            
            pw.close(); fw.close();
            br.close(); fr.close();
            return buffer;
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }  
    }

    // Generates two new files. n is the number of items in inFile.
    // Two new files will be named inFile + depth + 1 and inFile + depth + 2
    // respectively, e.g., if inFile is input.txt, then two new files will
    // be named input.txt11 and input.txt12 if depth is 1.
    // If you run the given .class file, you will see the new files being
    // created.   The new files will be created in the same folder where the
    // .class file is located.
    private static void splitFile(int n, String inFile, int depth) {
        // System.out.println("in splitFile");
        try {
            FileReader fr = new FileReader(inFile);
            BufferedReader br = new BufferedReader(fr);

            FileWriter fw1 = new FileWriter(inFile + depth + 1);
            PrintWriter pw1 = new PrintWriter(fw1);
            FileWriter fw2 = new FileWriter(inFile + depth + 2);
            PrintWriter pw2 = new PrintWriter(fw2);
        
            // Fill_it_in

            pw1.close(); fw1.close();
            pw2.close(); fw2.close();
            br.close();  fr.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }  
    }
    

    // Files f1 and f2 are merged into a new file f3
    // n is the number of items in the resulting f3
    private static void mergeFiles(int n, String f1, String f2, String f3) {
        // System.out.println(f1 + ", " + f2 + ", " + f3);
        try {
            FileReader fr1 = new FileReader(f1);
            BufferedReader br1 = new BufferedReader(fr1);
            FileReader fr2 = new FileReader(f2);
            BufferedReader br2 = new BufferedReader(fr2);

            FileWriter fw = new FileWriter(f3);
            PrintWriter pw = new PrintWriter(fw);
        
            String s1 = br1.readLine();
            int f1top = (s1 != null ?
                         Integer.parseInt(s1) : Integer.MAX_VALUE);
            String s2 = br2.readLine();
            int f2top = (s2 != null ?
                         Integer.parseInt(s2) : Integer.MAX_VALUE);

            // Fill_it_in

            pw.close();   fw.close();
            br1.close();  fr1.close();
            br2.close();  fr2.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }  
    }
    

    // This is very similar to the merge sort method that we studied for
    // regular in-memory merge sort.
    public static String[] extSort(String fname, int n, int buffSize) {
        sliceSize = buffSize;
        String retArr[] = extMergeSort(fname, n, 1);
        return retArr;
    }

    // inFile: the file to be sorted.
    // n: number of items in inFile.
    // depth: the depth of recursion to be used to generate file names.
    //        Run the executable given to see how it works.
    private static String[] extMergeSort(String inFile, int n, int depth) {

        if (n <= sliceSize) {
            // String[] src = sortFile(n, inFile);
            return;
        }
        String[] src = sortFile(n, inFile);
            
        splitFile(n, inFile, depth);

        // Sets up sizes: size1 and size2 to be used in the recursive calls
            // Fill_it_in
        int size1 = n/2;
        int size2 = n-size1;
        extMergeSort(inFile + depth + 1, size1, depth + 1);
        extMergeSort(inFile + depth + 2, size2, depth + 1);


//------------------------------------------------------------------

    // if ((high - low) < 2) {
    //             return;
    // }

        
    // int mid = (low + high) / 2;
    // mergeSort(dest, src, low, mid);
    // mergeSort(dest, src, mid, high);

    // if (src[mid - 1] <= src[mid]) {
    //     System.arraycopy(src, low, dest, low, high - low);
    //     return;
    // }
    String dest[] = new String[n];

    int p = 0; // 5 : 32
    int q = size1; // 10 : 43
 
    for (int i = 0; i < n; i++) {
        if ((q >= n) || (p < size1 && src[p] <= src[q])) {
            dest[i] = src[p++];
            // p++;
        }
        else {
            dest[i] = src[q++];
        }
    }









//------------------------------------------------------------------


        mergeFiles(n,
                   inFile + depth + 1 + "o",
                   inFile + depth + 2 + "o",
                   inFile + "o");
        return dest;
    }


    public static void main(String[] args) throws IOException {
        String inputFileName = args[0];
        int buffSize = Integer.parseInt(args[1]);
        
        Scanner input = new Scanner(new File(inputFileName));
        int n = 0;
        while (input.hasNext()) {
            n++;
            input.next();
            // System.out.println(input.next());
        }
        input.close();
        sortFile(n,inputFileName);
        
        System.out.println("n = " + n);

        String [] test = extSort(inputFileName, n, buffSize);
        for (int i=0;i<test.length ; i++ ) {
            System.out.println(test[i]);
            
        }

        /* You may use this to test your implementation.
        String inputFileName = generateInput(N);
        extSort(inputFileName, N);
        */
        
        /* Or this one if you want.
        String inputFileName = "./input.txt";
        Scanner input = new Scanner(new File(inputFileName));
        int n = 0;
        while (input.hasNext()) {
            n++;
            input.next();
        }
        input.close();
        
        System.out.println("n = " + n);

        extSort(inputFileName, n);
        */
    }


    // Not being used now, but you may use it to test your impl.
    static String generateInput(int n) {
        String fileName = "xsort.txt";
        Random rand = new Random();
  
        try {
            FileWriter fw = new FileWriter(fileName);
            PrintWriter pw = new PrintWriter(fw);
   
            for (int i = 0; i < n; i++)
                pw.println(rand.nextInt(101));
   
            pw.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
  
        return fileName;
    }


}