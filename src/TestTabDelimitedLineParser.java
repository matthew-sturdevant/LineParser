import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestTabDelimitedLineParser {

	/*
	 *   Test out the TabDelimitedLineParser functionality
	 */
	public static void main(String[] args) throws IllegalArgumentException{
		//Put this file in here for simplicity.
    	String fileName = "src/files/test_file.tab";
		File tabDelimitedTextFile = null; 
		FileInputStream fis = null;
		Scanner scanner = null;
		
		// make sure we actually have a filename and that it's not an empty
    	if (fileName == null || fileName.length() == 0) {
    		System.out.println("Invalid file name: + " + fileName + ". Please Confirm that the file exists.");
    		return;
    	}
    	try {
    		tabDelimitedTextFile = new File(fileName); 
    		fis = new FileInputStream(tabDelimitedTextFile);
        	scanner = new Scanner(fis);
        	if (scanner != null) {
		        String  nextLine = null;
		        boolean endOfFile = false;
		        while (!endOfFile) {
		        	//clear the value.
		        	nextLine = null;
			        if (scanner.hasNextLine()) {
			        	nextLine = scanner.nextLine();
			        	ILineParser tabLineParser  = LineParserFactory.getLineParser(tabDelimitedTextFile.getName(), nextLine);
			        	List<String> tabDelimitedLine = tabLineParser.getNextLineTokens();
			        	printList(tabDelimitedLine);
			        } else {
			        	ILineParser tabLineParser  = LineParserFactory.getLineParser(tabDelimitedTextFile.getName(), nextLine);
			        	List<String> tabDelimitedLine = tabLineParser.getNextLineTokens();
			        	printList(tabDelimitedLine);
			        	endOfFile = true;
			        }
		        }
        	}
	        
        } catch (IOException | IllegalArgumentException ex) {
        	// Either way lets just print the exception.
            Logger.getLogger(TestTabDelimitedLineParser.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
			try {
				if (fis != null)
					fis.close();
				if (scanner != null)
					scanner.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
        }
	}
	
	/*
	 * Format the lines to of tab delimited text.
	 */
	
	public static void printList(List<String> list){
		if (list != null && !list.isEmpty()) {
		    StringBuffer sb = new StringBuffer();
			for(int i = 0;i<list.size();i++){
		        sb.append("\"" + list.get(i) +"\"");
		        if (i != list.size()-1) {
		        	sb.append(", ");
		        }
		    }
		    System.out.println(sb.toString());
		} else {
			System.out.println("null");
		}
		
	}
	
}
