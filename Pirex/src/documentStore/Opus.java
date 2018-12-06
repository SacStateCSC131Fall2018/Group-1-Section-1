package documentStore;
import java.util.ArrayList; 
import java.util.List;



public class Opus {
	private List<Document> documents;
	private String title, author;
	private int ordinalNumber;

	public Opus(String title, String author) {
		if(title == null) {
			this.title = "None";
			this.author = author;
		}else if(author == null) {
			this.title = title;
			this.author = "Anonymous";
		}else {
			this.title = title;
			this.author = author;
		}

		documents = new ArrayList<Document>();
	}

	//getters and setters
	
	public Document getDocument(int index) {
		if(index > -1 && index < documents.size()){
			return documents.get(index);
		}else {
			return null;
		}
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		if (title != null) {
			this.title = title;
		}
		return;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		if(author != null) {
			this.author = author;
		}
		return;
	}
	
	public int getOrdinalNumber() {
		return ordinalNumber;
	}

	public int getIndex(Document document) {
		if(document != null) {
			return documents.indexOf(document);
		}else {
			return -1;
		}
	}









}
