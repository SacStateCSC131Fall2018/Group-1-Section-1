package SearchEngine;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import documentStore.Document;
import documentStore.Opus;
import documentStore.OpusStorage;
import indexing.IndexTerms;
import indexing.InvertedIndex;
import indexing.Posting;

public class Search {

	private OpusStorage documentStore;
	private InvertedIndex invertedIndex;

	public  Search(OpusStorage documentStore, InvertedIndex invertedIndex){
		this.documentStore = documentStore;
		this.invertedIndex = invertedIndex;
	}
	
	public ArrayList<SearchResult> searchQuery(String query) {
		ArrayList<SearchResult> result = new ArrayList<SearchResult>();
		String[] terms = IndexTerms.filterOperators(query);
		HashMap<Integer,Posting> termLocations = invertedIndex.getPosting(terms[0]);
		if(termLocations == null) {
			return null;
		}
		
		Set<Integer> keySet = termLocations.keySet();
		OpusStorage docStore = new OpusStorage();
		for(Integer key : keySet) {
			Opus opus = docStore.getOpus(key);
			Posting posting = termLocations.get(key);
			
			for(Integer docNum : posting.getDocumentNumbers()) {
				result.add(new SearchResult(key, docNum, opus.getDocument(docNum), opus));
			
			}
			
		}
		
		return result;
	}

}


