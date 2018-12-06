package indexing;
import java.util.HashMap;

public class InvertedIndex {

	private HashMap<String, HashMap<Integer, Posting>> index;

	public InvertedIndex() {
		index = new HashMap<String, HashMap<Integer, Posting>>();
	}
	
	//getters
	public HashMap<Integer, Posting> getPosting(String query){
		return index.get(query);

	}
	
	public HashMap<String, HashMap<Integer, Posting>> getIndex(){
		return index;
	}
	
	public void add(String query, int opusNum, int docNum) {
		HashMap<Integer, Posting> termLocation = index.get(query);
		Posting posting;
		if(termLocation == null) {
			posting = new Posting(opusNum);
			termLocation = new HashMap<Integer, Posting>();
			termLocation.put(opusNum, posting);
			index.put(query, termLocation);
		}else {
			posting = termLocation.get(opusNum);
			
			if(posting == null) {
				posting = new Posting(opusNum);
				termLocation.put(opusNum, posting);
			}else {
				posting.add(docNum);
			}
		}
		
	}
}
