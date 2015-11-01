import java.io.*;

public class UseSLL {

    public static void main (String [ ] args) {
        
        SLL<String> words = new SLL<String>();

        String word1 = "Apple";
        String word2 = "Pear";
        String word3 = "Kiwi";
        String word4 = "Orange";

        words.add(word4);  // | TAIL(apple) | null | pear | kiwi | HEAD(orange) |
        words.add(word3);
        words.add(word2);
        words.add(null);
        words.add(word1);

        System.out.println("List 1 : " + words);
        System.out.println("Size "+words.size());
        System.out.println("contains before: " + words.contains(word1));
        words.remove(word1);  // remove Apple
        System.out.println("contains after: " + words.contains(word1));
        System.out.println("List 2 : " + words);

        System.out.println("contains null 1: " + words.contains(null));

        words.remove(word3);  // remove Kiwi
        System.out.println("List 3 : " + words);
        System.out.println("Size "+words.size());

        words.remove(word4);  // remove Orange
        System.out.println("List 4 : " + words);

        words.remove(word2);  // remove Pear
        System.out.println("List 5 : " + words);
        System.out.println("Size "+words.size());

        words.remove(word4);  // remove Orange once more on empty list
        System.out.println("List 6 : " + words);

        words.remove(null);  // remove Orange once more on empty list
        System.out.println("List 7 : " + words);

        System.out.println("contains null 2: " + words.contains(null));

    }

}