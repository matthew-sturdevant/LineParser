import java.io.IOException;
import java.util.List;

public interface ILineParser {
	public List<String> getNextLineTokens() throws IOException;
}
