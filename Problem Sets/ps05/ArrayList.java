// Collin Blinder
// cblinder@students.pitzer.edu
// Note that this implementation is not complete to the
// Java's documentation.  It is meant to give you an idea on
// how you might implement one.

// This implementation uses a nested class to implement its iterator.
// The testing code (main) is also in the same file.
//
// See the one in the folder named 'non_nested' for an implementation
// where iterator is implemented as a separate class.  And main is also
// separated as a separate class.  We will not study that implementation in
// class.  I am merely providing an alternative just to show you how different
// it would be.  The inner class implementation is considered better.

import java.util.Iterator;
import java.util.NoSuchElementException;


public class ArrayList<E> {

    final private static int NOT_FOUND = -1;
    final private static int INITSIZE = 5;
    final private static int EXPANSIONFACTOR = 2;
    
    // elements.size() >= size
    private E[] elements;
    private int size;
    
    public ArrayList() {
        // Java does not allow an array of type E to be created
        // so must create an Object array and typecast
        elements = (E[])new Object[INITSIZE];
        size = 0;
    }

    public boolean add(E o) {
        boolean boolReturn = false;
        size++;
        if(size == elements.length){
            
            E[] copyArray;
            copyArray = (E[])new Object[(elements.length)*2];
            System.arraycopy(elements,0,copyArray,0, elements.length);
            elements = copyArray; 
            elements[size+1] = o;    
        }
        for(int i=0; i<elements.length; i++){
            

            if(elements[i]==null){
                elements[i] = o;
                boolReturn = true; //exit for loop. If does not work may use i = this.length
                i = elements.length;
            }

        }
        return boolReturn;
    }

    public boolean contains(E o) {
        return (indexOf(o) >= 0);
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return (E)elements[index];
    }

    // Returns the index of o in elements or -1 if o is not found in elements.
    public int indexOf(E o) {
        int returnInt = -1;
        for(int i=0; i<elements.length; i++){
            if(elements[i]==o){
                returnInt = i;
                
            }
            i = elements.length;
        }
        return returnInt;
    }

    public void set(int index, E o) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        elements[index] = o;
    }

    public boolean remove(Object o) {
        int pos = findPos(o);
        if (pos == NOT_FOUND) {
            return false;
        }
        else {
            remove(pos);
            return true;
        }
    }

    // Removes the element in the index position filling in the hole.
    // Returns the element being removed.
    public E remove(int index) {
        E returnElement = null;
        for(int i=0; i<elements.length; i++){
            if(i==index||i>index){
                elements[i]= elements[i+1];
                returnElement = elements[i];
                size--;
            }
        }
        return returnElement;
    }

    private int findPos(Object o) {
        for (int i = 0; i < size(); i++) {
            if (o == null) {
                if (elements[i] == null) {
                    return i;
                }
            }
            else if (o.equals(elements[i])) {
                return i;
            }
        }
        return NOT_FOUND;
    }

    public int size() {
        return size;
    }

    public Iterator<E> iterator () {
        return (new ArrayListIterator());
        // If you implemented ArrayListIterator as a separate class
        // rather than as an inner class, you would have to pass
        // the current ArrayList object, i.e., this, as an actual
        // argument as follows.  If you did that, then you would
        // have to modify ArrayListIterator class appropriately
        // as well.
        //
        // return (new ArrayListIterator(this));
    }

    private class ArrayListIterator implements Iterator<E> {

        private int cursor;

        public ArrayListIterator() {
            cursor = 0;
        }

        public boolean hasNext() {
            boolean boolReturn = false;
            
            if(cursor<elements.length){
                
                boolReturn = true;
            }
            
            return boolReturn;
        }

        public E next() {
            // System.out.println("cursor number: "+cursor);
            cursor++;
            if (!hasNext()) {
                // System.out.println("cursor number: "+cursor);
                cursor = 0;
                // System.out.println("cursor number: "+cursor);
                
                throw new NoSuchElementException();
            }
            else{
                return elements[cursor];
            }
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static void main(String[] args) {
        // ArrayList<Integer> ints = new ArrayList<Integer>();
        // ArrayList<String> strArray1= new ArrayList<String>();
        ArrayList<Integer> ints = new ArrayList<Integer>();
        for (int i = 0; i < 11; i++) {
            ints.add(new Integer(i));  // This would certainly work
            // System.out.println("Elements Length: "+elements.getLen());
            // ints.add(i);  // This would work as well due to autoboxing
        }
        Iterator<Integer> itr = ints.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }
}



