package indexing;
import java.util.HashSet;
import java.util.Set;

public class Posting {//(Integer docIdentifier, {Posting = termLocations})

	private int ordinalNumberOpus;
	private Set<Integer> ordinalNumDocument;
	
	public Posting(int ordinalNumberOpus) {
		this.ordinalNumberOpus = ordinalNumberOpus;
		ordinalNumDocument = new HashSet<Integer>();
	}
	
	public int getOpusNumber() {
		return this.ordinalNumberOpus;
	}
	
	public Set<Integer> getDocumentNumbers() {
		return ordinalNumDocument;
	}
	
	public void add(int ordinalNumberDoc) {
		ordinalNumDocument.add((Integer)ordinalNumberDoc);
	}
	
	
}
