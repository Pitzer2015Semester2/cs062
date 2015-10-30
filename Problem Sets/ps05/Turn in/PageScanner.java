// Collin Blinder
// cblinder@students.pitzer.edu
import java.util.*;
import java.io.*;
public class PageScanner{

	private String inFileName;
	private String outFile;
	private TreeSet listOfCommons = new TreeSet();

	public PageScanner(String inFileName, String outFile) throws IOException{
		this.outFile = outFile;
		this.inFileName = inFileName;
		// Scanner commonScanner = new Scanner(new File("common.in1.txt"));
		PageScanIterator pageIterator = new PageScanIterator("common.in1.txt");
		while(pageIterator.hasNext()){
			String parseString = pageIterator.nextIn();
			listOfCommons.add(parseString);
		}
	}
	
	//This function is the workhorse of the program. It creates an an instance of PageScanIterator which is used to scan in the 
	//text from the incoming file to be parsed. It created a PrintWriter and writes the unique words to outFile.txt.
	public void scan(){
		try{
			PrintWriter printer = new PrintWriter(new File(outFile));
			// PageScanIterator pageIterator = new PageScanIterator(inFileName);
			String text = new PageScanIterator(inFileName).next();
			//regex replacements to clean string of all html and unnecessary puntuation, spacing, and returns which might mess up the printing.
			text = text.replaceAll("\\<.*?\\>","");
			text = text.replaceAll("[.,]","");
			text = text.replaceAll("\\s"," ");
			text = text.replaceAll("\r?\n|\r","");
			String[] textarray = text.split(" ");
			for(int i = 0; i<textarray.length; i++){
				String testString = textarray[i].toLowerCase();
				if(!listOfCommons.contains(testString) && testString!=""){
					printer.println(testString);
				} 
			}
			printer.close();
		}	
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
	}
	// simply creates and returns an instance of the PageScanIterator.
    public Iterator<String> iterator (String inFileName) {
        return (new PageScanIterator(inFileName));
    }

    private class PageScanIterator implements Iterator<String>{

        private String inFileName;
        private String outFile;
        private Scanner internalScanner;
        PrintWriter printer; 
        
        public PageScanIterator(String inFileName){
            inFileName = inFileName;
            outFile = outFile;
            try{
	            internalScanner = new Scanner(new File(inFileName));
	            // printer = new PrintWriter(outFile);
            }
            catch (FileNotFoundException e){
	            e.printStackTrace();
	        }

        }
        public boolean hasNext() {
            return internalScanner.hasNext();
        }

        // this next parses the incomind html to produce a solid string.
        public String next() {
             return internalScanner.useDelimiter("/z").next();
        }

        // This next simply parses the common file.
        public String nextIn() {
             return internalScanner.next();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
	public static void main(String[] args) throws IOException {
		String fileIn = args[0]; //HTML file
		String outFile = args[1]; //output file location.
		PageScanner pageScanner = new PageScanner(fileIn, outFile);
		pageScanner.scan();
	}
}