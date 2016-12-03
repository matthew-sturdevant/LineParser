import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 *  Parse a tab delimited line and return a List<String> of the results.x 
 */

public class TabDelimitedLineParser implements ILineParser {
	
	private String tabDelimitedLine = null;

		// We take the line we need to parse on the constructor.  
	public TabDelimitedLineParser(String tabDelimitedLine) {
		this.tabDelimitedLine = tabDelimitedLine;
	}
	
	/*
	 * (non-Javadoc)
	 * @see ILineParser#getNextLineTokens()
	 * split the line into tab delimited data and return it as a List<String>;
	 */
	
	public List<String> getNextLineTokens() throws IOException {
		List<String> tokens = null;
		if (tabDelimitedLine != null) {
			if (tabDelimitedLine.length() > 0) {
				
				String[] tabDelimitedArray = tabDelimitedLine.split("\t");
				tokens = new ArrayList<String>(Arrays.asList(tabDelimitedArray));
			} else {
				throw new IOException("Line to parse is an empty String.");
			}
		}
		return tokens;
	}

}
