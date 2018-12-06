package documentStore;
import java.util.ArrayList;
import java.util.List;

public class Document {
	
	private List<String> text;
	public Document() {
		text = new ArrayList<String>();
	}
	
	public List<String> getText() {
		return text;
	}
	
	public String getShortForm() {
		if(text.size() > 0) {
			return text.get(0);
		}else {
			return "";
		}
	}
	
	public String printText() {
		String fullText = "";
		for(int i = 0; i < text.size(); i++) {
			fullText += (text.get(i) + "\n");
		}
			return fullText;
	}
	
	
}
