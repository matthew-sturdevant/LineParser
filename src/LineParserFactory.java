

public class LineParserFactory {

	// Pass in the filename to check the extension
	// make sure it's a valid file name and not null;
	// We currently only take one type of file ".tab".  
	public static ILineParser getLineParser(String fileName, String line) throws IllegalArgumentException{
        if (fileName != null && fileName.length() > 0) {
        	if (fileName.endsWith("tab")) {
        		return new TabDelimitedLineParser(line);
            } else {
                throw new IllegalArgumentException("File " + fileName + " can not be parsed due to invalid Extension");
            }
        } else {
        	throw new IllegalArgumentException("Empty String passed for file name");
        }	
		
	}
}
