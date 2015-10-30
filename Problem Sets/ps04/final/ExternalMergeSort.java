/**
 * External merge sort: sorting a file containing words, possibly multiple
 * words per line.
 *
 * Art Lee for CS 62
 * 10/3/2015
 */

//Collin Blinder
//cblinder@students.pitzer.edu

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Random;



public class ExternalMergeSort{

    private static int N = 100; // Number of items in the file to be sorted.
    private static int sliceSize = 20;  // Max number of items the memory buffer can hold.
    private static String protectedFile =""; // saves the original file from being destroyed
    private static String MAXVAL = "zzzzz";
    private static String readItem(Scanner scan) {
        if (scan.hasNext()) {
            return scan.next();
        }
        else {
            return null;
        }
    }
    private static void sortFile(int n, String inFile) {
        try {
            File file = new File(inFile);
            Scanner scan = new Scanner(file);
           int[] buffer = new int[n];
            for (int i = 0; i < n; i++) {
                if(scan.hasNextInt()){
                    buffer[i] = scan.nextInt();
                }
            }

            Quick.qsort(buffer);

            FileWriter fw = new FileWriter(inFile + "o");
            PrintWriter pw = new PrintWriter(fw);
            for (int j = 0; j < n; j++) {
                pw.print(buffer[j]+"\n");
            }
            file.delete();
            pw.close(); fw.close();
            scan.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }  
    }
    private static void splitFile(int n, String inFile, int depth) {
        try {
            File file = new File(inFile);
            Scanner scan = new Scanner(file);
            FileWriter fw1 = new FileWriter(inFile + depth + 1);
            PrintWriter pw1 = new PrintWriter(fw1);
            FileWriter fw2 = new FileWriter(inFile + depth + 2);
            PrintWriter pw2 = new PrintWriter(fw2);
            int nHalf = n/2;

            for (int j = 0; j < nHalf; j++) {
                pw1.print(scan.next()+"\n");
            }

            for (int j = 0; j < n-nHalf; j++) {
                pw2.print(scan.next()+"\n");
            }
            if(file.getName()!=protectedFile){
                file.delete();
            }
            pw1.close(); fw1.close();
            pw2.close(); fw2.close();
            scan.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }  
    }
    private static void mergeFiles(int n, String f1, String f2, String f3) {
        try {
            File file1 = new File(f1);
            File file2 = new File(f2);
            Scanner scan1 = new Scanner(file1);
            Scanner scan2 = new Scanner(file2);
            FileWriter fw = new FileWriter(f3);
            PrintWriter pw = new PrintWriter(fw);
            // System.out.println(f3);
            String s1 = readItem(scan1);
            int f1top = (s1 != null ?
                         Integer.parseInt(s1) : Integer.MAX_VALUE);
            String s2 = readItem(scan2);
            int f2top = (s2 != null ?
                         Integer.parseInt(s2) : Integer.MAX_VALUE);
            int arr1[] = new int[n];
            int scan1Nxt = f1top;
            int scan2Nxt = f2top;
            


           while(f1top!=Integer.MAX_VALUE&&f2top!=Integer.MAX_VALUE){
                if (scan1Nxt<=scan2Nxt) {  
                    pw.print(scan1Nxt+"\n");
                    s1 = readItem(scan1);
                    f1top = (s1 != null ?
                         Integer.parseInt(s1) : Integer.MAX_VALUE);
                    scan1Nxt = f1top ;

                }
                else if(scan1Nxt>=scan2Nxt) {         
                    pw.print(scan2Nxt+"\n");
                    s2 = readItem(scan2);
                    f2top = (s2 != null ?
                         Integer.parseInt(s2) : Integer.MAX_VALUE);
                    scan2Nxt = f2top;
                } else{              
                    pw.print(scan2Nxt+"\n");
                    pw.print(scan1Nxt+"\n");
                    s1 = readItem(scan1);
                    f1top = (s1 != null ?
                         Integer.parseInt(s1) : Integer.MAX_VALUE);
                    s2 = readItem(scan2);
                    f2top = (s2 != null ?
                         Integer.parseInt(s2) : Integer.MAX_VALUE);
                    scan1Nxt = f1top ;
                    scan2Nxt = f2top;      
                }
            }
            if (f1top==Integer.MAX_VALUE && f2top!=Integer.MAX_VALUE) {
                while(f2top!=Integer.MAX_VALUE){
                    pw.print(f2top+"\n");
                    s2 = readItem(scan2);
                    f2top = (s2 != null ?
                         Integer.parseInt(s2) : Integer.MAX_VALUE);

                }
            } else if (f1top!=Integer.MAX_VALUE && f2top==Integer.MAX_VALUE) {
                while(f1top!=Integer.MAX_VALUE ){
                    pw.print(f1top+"\n");
                    s1 = readItem(scan1);
                    f1top = (s1 != null ?
                         Integer.parseInt(s1) : Integer.MAX_VALUE);
                }
            } else{return;}

            if(file1.delete()){
                System.out.println(file1.getName());
            }           
             if(file2.delete()){
                System.out.println(file2.getName());
            }
            // file2.delete();
            pw.close();   fw.close();
            scan1.close(); scan2.close();

        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }  


    }
    public static void extSort(String fname, int n, int buffSize) {
        sliceSize = buffSize;
        protectedFile = fname;
        extMergeSort(fname, n, 1);
    }
    private static void extMergeSort(String inFile, int n, int depth) {
        if (n <= sliceSize) {
            sortFile(n, inFile);
            return;
        }   
        splitFile(n, inFile, depth);
        int size1 = n/2;
        int size2 = n-size1;
        extMergeSort(inFile + depth + 1, size1, depth + 1);
        extMergeSort(inFile + depth + 2, size2, depth + 1);
        mergeFiles(n,
                   inFile + depth + 1 + "o",
                   inFile + depth + 2 + "o",
                   inFile + "o");
    }

       public static void main(String[] args) throws IOException {
            String inputFileName = args[0];
            int buffSize = Integer.parseInt(args[1]);
            
            Scanner input = new Scanner(new File(inputFileName));
            int n = 0;
            while (input.hasNext()) {
                n++;
                input.next();
            }
            input.close();
            extSort(inputFileName, n, buffSize);     
    }
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